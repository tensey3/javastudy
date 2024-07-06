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

    public Keyget() {
        setTitle("Key Event Demo");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea);
        addKeyListener(this);
        setFocusable(true); // フレームがフォーカスを受け取れるようにする
        requestFocusInWindow(); // フレームにフォーカスを要求する
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // キーがタイプされたときの処理
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                isAKeyPressed = true;
                break;
            case 'w':
            case ' ':
                isWKeyPressed = true;
                break;
            case 's':
                isSKeyPressed = true;
                break;
            case 'd':
                isDKeyPressed = true;
                break;
        }

        updateDirection();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                isAKeyPressed = false;
                break;
            case 'w':
            case ' ':
                isWKeyPressed = false;
                break;
            case 's':
                isSKeyPressed = false;
                break;
            case 'd':
                isDKeyPressed = false;
                break;
        }
    }

    private void updateDirection() {
        if (isWKeyPressed && isAKeyPressed) {
            textArea.append("↖︎\n");
        } else if (isWKeyPressed && isDKeyPressed) {
            textArea.append("↗︎\n");
        } else if (isSKeyPressed && isAKeyPressed) {
            textArea.append("↙︎\n");
        } else if (isSKeyPressed && isDKeyPressed) {
            textArea.append("↘︎\n");
        } else if (isWKeyPressed) {
            textArea.append("↑\n");
        } else if (isSKeyPressed) {
            textArea.append("↓\n");
        } else if (isAKeyPressed) {
            textArea.append("←\n");
        } else if (isDKeyPressed) {
            textArea.append("→\n");
        }
    }

    public static void main(String[] args) {
        Keyget frame = new Keyget();
        frame.setVisible(true);
    }
}