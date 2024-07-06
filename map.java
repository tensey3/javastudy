// import java.awt.BorderLayout;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;
// import java.util.Timer;
// import java.util.TimerTask;
// import javax.swing.ImageIcon;
// import javax.swing.JFrame;
// import javax.swing.JLabel;
// import javax.swing.SwingUtilities;

// public class Keyget extends JFrame implements KeyListener {
//     private JLabel imageLabel;
//     private boolean isAKeyPressed = false;
//     private boolean isWKeyPressed = false;
//     private boolean isSKeyPressed = false;
//     private boolean isDKeyPressed = false;
//     private String lastDirection = "";
//     private Timer timer;
//     private boolean isUpdatePending = false;

//     private ImageIcon upImage;
//     private ImageIcon downImage;
//     private ImageIcon leftImage;
//     private ImageIcon rightImage;
//     private ImageIcon upLeftImage;
//     private ImageIcon upRightImage;
//     private ImageIcon downLeftImage;
//     private ImageIcon downRightImage;

//     public Keyget() {
//         setTitle("Key Event Demo");
//         setSize(1300, 1200);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//         imageLabel = new JLabel();
//         imageLabel.setHorizontalAlignment(JLabel.CENTER);
//         imageLabel.setVerticalAlignment(JLabel.CENTER);
//         add(imageLabel, BorderLayout.CENTER);
        
//         // 画像の読み込み
//         upImage = new ImageIcon("up.png");
//         downImage = new ImageIcon("down.png");
//         leftImage = new ImageIcon("left.png");
//         rightImage = new ImageIcon("right.png");
//         upLeftImage = new ImageIcon("up_left.png");
//         upRightImage = new ImageIcon("up_right.png");
//         downLeftImage = new ImageIcon("down_left.png");
//         downRightImage = new ImageIcon("down_right.png");
        
//         addKeyListener(this);
//         setFocusable(true);
//         requestFocusInWindow();

//         timer = new Timer();
//     }

//     @Override
//     public void keyTyped(KeyEvent e) {
//         // キーがタイプされたときの処理
//     }

//     @Override
//     public void keyPressed(KeyEvent e) {
//         updateKeyState(e, true);
//         scheduleUpdate();
//     }

//     @Override
//     public void keyReleased(KeyEvent e) {
//         updateKeyState(e, false);
//         scheduleUpdate();
//     }

//     private void updateKeyState(KeyEvent e, boolean isPressed) {
//         int keyCode = e.getKeyCode();
//         switch (keyCode) {
//             case KeyEvent.VK_A:
//                 isAKeyPressed = isPressed;
//                 break;
//             case KeyEvent.VK_W:
//             case KeyEvent.VK_SPACE:
//                 isWKeyPressed = isPressed;
//                 break;
//             case KeyEvent.VK_S:
//                 isSKeyPressed = isPressed;
//                 break;
//             case KeyEvent.VK_D:
//                 isDKeyPressed = isPressed;
//                 break;
//         }
//     }

//     private void scheduleUpdate() {
//         if (!isUpdatePending) {
//             isUpdatePending = true;
//             timer.schedule(new TimerTask() {
//                 @Override
//                 public void run() {
//                     SwingUtilities.invokeLater(() -> {
//                         updateDirection();
//                         isUpdatePending = false;
//                     });
//                 }
//             }, 10); // 10ミリ秒の遅延
//         }
//     }

//     private void updateDirection() {
//         String newDirection = getDirection();

//         if (!newDirection.equals(lastDirection)) {
//             switch (newDirection) {
//                 case "up_left":
//                     imageLabel.setIcon(upLeftImage);
//                     break;
//                 case "up_right":
//                     imageLabel.setIcon(upRightImage);
//                     break;
//                 case "down_left":
//                     imageLabel.setIcon(downLeftImage);
//                     break;
//                 case "down_right":
//                     imageLabel.setIcon(downRightImage);
//                     break;
//                 case "up":
//                     imageLabel.setIcon(upImage);
//                     break;
//                 case "down":
//                     imageLabel.setIcon(downImage);
//                     break;
//                 case "left":
//                     imageLabel.setIcon(leftImage);
//                     break;
//                 case "right":
//                     imageLabel.setIcon(rightImage);
//                     break;
//                 default:
//                     imageLabel.setIcon(null);
//                     break;
//             }
//             lastDirection = newDirection;
//         }
//     }

//     private String getDirection() {
//         if (isWKeyPressed && isAKeyPressed) {
//             return "up_left";
//         } else if (isWKeyPressed && isDKeyPressed) {
//             return "up_right";
//         } else if (isSKeyPressed && isAKeyPressed) {
//             return "down_left";
//         } else if (isSKeyPressed && isDKeyPressed) {
//             return "down_right";
//         } else if (isWKeyPressed) {
//             return "up";
//         } else if (isSKeyPressed) {
//             return "down";
//         } else if (isAKeyPressed) {
//             return "left";
//         } else if (isDKeyPressed) {
//             return "right";
//         }
//         return "";
//     }

//     public static void main(String[] args) {
//         SwingUtilities.invokeLater(() -> {
//             Keyget frame = new Keyget();
//             frame.setVisible(true);
//         });
//     }
// }
