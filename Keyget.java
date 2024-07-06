import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Keyget extends JFrame implements KeyListener {
    private static final int WINDOW_WIDTH = 1300;
    private static final int WINDOW_HEIGHT = 1200;
    private static final int FONT_SIZE = 48;

    private JTextArea textArea;
    private boolean isAKeyPressed, isWKeyPressed, isSKeyPressed, isDKeyPressed;
    private String lastDirection = "";

    public Keyget() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Key Event Demo");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        textArea.setAlignmentX(CENTER_ALIGNMENT);
        textArea.setAlignmentY(CENTER_ALIGNMENT);
        add(textArea, BorderLayout.CENTER);
        
        addKeyListener(this);
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // キーがタイプされたときの処理（必要な場合に実装）
    }

    @Override
    public void keyPressed(KeyEvent e) {
        updateKeyState(e, true);
        updateDirection();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        updateKeyState(e, false);
        updateDirection();
    }

    private void updateKeyState(KeyEvent e, boolean isPressed) {
        switch (e.getKeyChar()) {
            case 'a': isAKeyPressed = isPressed; break;
            case 'w':
            case ' ': isWKeyPressed = isPressed; break;
            case 's': isSKeyPressed = isPressed; break;
            case 'd': isDKeyPressed = isPressed; break;
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
        if (isWKeyPressed && isAKeyPressed) return "↖️";
        if (isWKeyPressed && isDKeyPressed) return "↗️";
        if (isSKeyPressed && isAKeyPressed) return "↙︎";
        if (isSKeyPressed && isDKeyPressed) return "↘︎";
        if (isWKeyPressed) return "↑";
        if (isSKeyPressed) return "↓";
        if (isAKeyPressed) return "←";
        if (isDKeyPressed) return "→";
        return "";
    }

    public static void main(String[] args) {
        Keyget frame = new Keyget();
        frame.setVisible(true);
    }
}