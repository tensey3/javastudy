import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Flam extends JFrame {
    public Flam() {
        setTitle("Key Event Demo");
        setSize(1300, 1200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Keyset keyset = new Keyset(); // Keysetクラスのインスタンスを生成
        add(keyset); // Keysetクラスのインスタンスをフレームに追加

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Flam(); // Flamクラスのインスタンスを生成して表示
        });
    }
}
