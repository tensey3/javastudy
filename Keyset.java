import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Keyset extends JPanel implements KeyListener {
    private final JTextArea textArea;
    private boolean isAKeyPressed = false;
    private boolean isWKeyPressed = false;
    private boolean isSKeyPressed = false;
    private boolean isDKeyPressed = false;
    private String lastDirection = "";
    private final Timer timer;
    private boolean isUpdatePending = false;

    public Keyset() {
        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("SansSerif", Font.BOLD, 34));
        add(textArea, BorderLayout.CENTER);

        timer = new Timer();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // キーがタイプされたときの処理
    }

    @Override
    public void keyPressed(KeyEvent e) {
        updateKeyState(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updateKeyState(e, false);
    }

    private void updateKeyState(KeyEvent e, boolean isPressed) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_A -> isAKeyPressed = isPressed;
            case KeyEvent.VK_W, KeyEvent.VK_SPACE -> isWKeyPressed = isPressed;
            case KeyEvent.VK_S -> isSKeyPressed = isPressed;
            case KeyEvent.VK_D -> isDKeyPressed = isPressed;
        }
        scheduleUpdate();
    }

    private void scheduleUpdate() {
        if (!isUpdatePending) {
            isUpdatePending = true;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    updateDirection();
                    isUpdatePending = false;
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
}