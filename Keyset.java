import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Keyset extends JPanel implements KeyListener {
    private final JPanel directionPanel;
    private final JLabel currentDirectionLabel;
    private boolean isAKeyPressed = false;
    private boolean isWKeyPressed = false;
    private boolean isSKeyPressed = false;
    private boolean isDKeyPressed = false;
    private boolean isSpaceKeyPressed = false;
    private String lastDirection = "";
    private final Timer timer;
    private boolean isUpdatePending = false;
    private final int imageSize;
    private long keyPressTime = 0;
    private static final long PRESS_THRESHOLD = 50;

    public Keyset() {
        setLayout(new BorderLayout());

        directionPanel = new JPanel();
        directionPanel.setLayout(new BoxLayout(directionPanel, BoxLayout.Y_AXIS));
        add(directionPanel, BorderLayout.CENTER);

        currentDirectionLabel = new JLabel();
        add(currentDirectionLabel, BorderLayout.NORTH);

        Font font = new Font("SansSerif", Font.BOLD, 34);
        imageSize = font.getSize();

        timer = new Timer();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

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
            case KeyEvent.VK_W -> isWKeyPressed = isPressed;
            case KeyEvent.VK_S -> isSKeyPressed = isPressed;
            case KeyEvent.VK_D -> isDKeyPressed = isPressed;
            case KeyEvent.VK_SPACE -> isSpaceKeyPressed = isPressed;
        }

        if (isPressed) {
            keyPressTime = System.currentTimeMillis();
        } else {
            keyPressTime = 0;
        }

        scheduleUpdate();
    }

    private void scheduleUpdate() {
        if (!isUpdatePending) {
            isUpdatePending = true;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    long currentTime = System.currentTimeMillis();
                    if (keyPressTime != 0 && (currentTime - keyPressTime >= PRESS_THRESHOLD)) {
                        updateDirection();
                    } else {
                        isUpdatePending = false;
                    }
                }
            }, 10);
        }
    }

    private void updateDirection() {
        String newcomen = getDirection();

        if (!newcomen.isEmpty() && !newcomen.equals(lastDirection)) {
            ImageIcon icon = getDirectionIcon(newcomen);
            currentDirectionLabel.setIcon(icon);
            JLabel pastDirectionLabel = new JLabel(icon);
            directionPanel.add(pastDirectionLabel, 0);
            directionPanel.revalidate();
            lastDirection = newcomen;
        } else if (newcomen.isEmpty()) {
            currentDirectionLabel.setIcon(null);
            lastDirection = "";
        }
        isUpdatePending = false;
    }

    private String getDirection() {
        if ((isWKeyPressed || isSpaceKeyPressed) && isAKeyPressed) {
            return "↖️";
        } else if ((isWKeyPressed || isSpaceKeyPressed) && isDKeyPressed) {
            return "↗︎";
        } else if (isSKeyPressed && isAKeyPressed) {
            return "↙︎";
        } else if (isSKeyPressed && isDKeyPressed) {
            return "↘︎";
        } else if (isWKeyPressed || isSpaceKeyPressed) {
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

    private ImageIcon getDirectionIcon(String direction) {
        String imageName = switch (direction) {
            case "↖️" -> "up_left.png";
            case "↗︎" -> "up_right.png";
            case "↙︎" -> "down_left.png";
            case "↘︎" -> "down_right.png";
            case "↑" -> "up.png";
            case "↓" -> "down.png";
            case "←" -> "left.png";
            case "→" -> "right.png";
            default -> null;
        };
        if (imageName == null) return null;

        ImageIcon icon = new ImageIcon(imageName);
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}
