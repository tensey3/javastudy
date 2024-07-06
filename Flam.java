import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Flam extends JFrame {
    public Flam() {
        setTitle("Key Event Demo");
        setSize(1300, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Keyset keyset = new Keyset(); // Keysetクラスのインスタンスを生成
        add(keyset, BorderLayout.CENTER); // Keysetクラスのインスタンスをフレームの中央に追加

        JTextArea timerTextArea = new JTextArea();
        timerTextArea.setEditable(false);
        timerTextArea.setFont(new Font("SansSerif", Font.PLAIN, 24));
        add(timerTextArea, BorderLayout.EAST); // タイマー表示用のエリアをフレームの右側に追加

        new Timer(timerTextArea); // タイマーのカウントを管理するTimerクラスのインスタンスを生成

        addKeyListener(keyset); // KeysetをKeyListenerとして追加
        setFocusable(true);
        requestFocusInWindow();
    }
}
