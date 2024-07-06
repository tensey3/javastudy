import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Keyget extends JFrame implements KeyListener {
    private JTextArea textArea;
    private boolean isAKeyPressed = false;
    private boolean isWKeyPressed = false;
    private boolean isSKeyPressed = false;
    private boolean isDKeyPressed = false;
    private String lastDirection = "";
    private Timer timer;
    private boolean isUpdatePending = false;

    public Keyget() {
        setTitle("Key Event Demo");
        setSize(1300, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("SansSerif", Font.BOLD, 48));
        textArea.setAlignmentX(CENTER_ALIGNMENT);
        textArea.setAlignmentY(CENTER_ALIGNMENT);
        add(textArea, BorderLayout.CENTER);
        
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();

        timer = new Timer();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // キーがタイプされたときの処理
    }

    @Override
    public void keyPressed(KeyEvent e) {
        updateKeyState(e, true);
        scheduleUpdate();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updateKeyState(e, false);
        scheduleUpdate();
    }

    private void updateKeyState(KeyEvent e, boolean isPressed) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A:
                isAKeyPressed = isPressed;
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_SPACE:
                isWKeyPressed = isPressed;
                break;
            case KeyEvent.VK_S:
                isSKeyPressed = isPressed;
                break;
            case KeyEvent.VK_D:
                isDKeyPressed = isPressed;
                break;
        }
    }

    private void scheduleUpdate() {
        if (!isUpdatePending) {
            isUpdatePending = true;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    SwingUtilities.invokeLater(() -> {
                        updateDirection();
                        isUpdatePending = false;
                    });
                }
            }, 10); // 10ミリ秒の遅延
        }
    }

    private void updateDirection() {
        String newDirection = getDirection();

        if (!newDirection.isEmpty() && !newDirection.equals(lastDirection)) {
            textArea.setText(newDirection + "\n" + textArea.getText());
            lastDirection = newDirection;
        } else if (newDirection.isEmpty()) {
            lastDirection = "";
        }
    }

    private String getDirection() {
        if (isWKeyPressed && isAKeyPressed) {
            return "↖️";
        } else if (isWKeyPressed && isDKeyPressed) {
            return "↗︎";
        } else if (isSKeyPressed && isAKeyPressed) {
            return "↙︎";
        } else if (isSKeyPressed && isDKeyPressed) {
            return "↘︎";
        } else if (isWKeyPressed) {
            return "↑";
        } else if (isSKeyPressed) {
            return "↓";
        } else if (isAKeyPressed) {
            return "←";
        } else if (isDKeyPressed) {
            return "→";
        }
        return "";
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Keyget frame = new Keyget();
            frame.setVisible(true);
        });
    }
}
