import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Keyget extends JFrame implements KeyListener {
    private JTextArea textArea;
    private boolean isAKeyPressed = false;
    private boolean isWKeyPressed = false;
    private boolean isSKeyPressed = false;
    private boolean isDKeyPressed = false;
    private String lastDirection = "";
    private boolean isDiagonalReleased = false;

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
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // キーがタイプされたときの処理
    }

    @Override
    public void keyPressed(KeyEvent e) {
        updateKeyState(e, true);
        updateDirection();
        isDiagonalReleased = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updateKeyState(e, false);
        if (!isDiagonalReleased) {
            updateDirection();
        }
    }

    private void updateKeyState(KeyEvent e, boolean isPressed) {
        switch (e.getKeyChar()) {
            case 'a':
                isAKeyPressed = isPressed;
                break;
            case 'w':
            case ' ':
                isWKeyPressed = isPressed;
                break;
            case 's':
                isSKeyPressed = isPressed;
                break;
            case 'd':
                isDKeyPressed = isPressed;
                break;
        }

        // スペースキーと方向キーの同時押し解除を検出
        if (!isPressed && (e.getKeyChar() == ' ' || e.getKeyChar() == 'w')) {
            if (isAKeyPressed || isDKeyPressed) {
                isDiagonalReleased = true;
            }
        } else if (!isPressed && (e.getKeyChar() == 'a' || e.getKeyChar() == 'd')) {
            if (isWKeyPressed) {
                isDiagonalReleased = true;
            }
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
            return "↗️";
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
        Keyget frame = new Keyget();
        frame.setVisible(true);
    }
}