package test;

import java.awt.event.KeyEvent;
import src.Keyset;

public class KeysetTest {
    private Keyset keyset;

    public static void main(String[] args) {
        KeysetTest test = new KeysetTest();
        test.setUp();
        test.testInitialDirectionIsEmpty();
        test.testDirectionAfterPressingW();
        test.testDirectionAfterPressingWA();
        test.testDirectionAfterReleasingW();
        System.out.println("すべてのテストが成功しました。");
    }

    public void setUp() {
        keyset = new Keyset();
    }

    public void testInitialDirectionIsEmpty() {
        assert "".equals(keyset.getDirection()) : "初期の方向が空でない";
    }

    public void testDirectionAfterPressingW() {
        keyset.keyPressed(new KeyEvent(keyset, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W'));
        assert "↑".equals(keyset.getDirection()) : "Wキーを押した後の方向が正しくない";
    }

    public void testDirectionAfterPressingWA() {
        keyset.keyPressed(new KeyEvent(keyset, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W'));
        keyset.keyPressed(new KeyEvent(keyset, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A'));
        assert "↖️".equals(keyset.getDirection()) : "WキーとAキーを押した後の方向が正しくない";
    }

    public void testDirectionAfterReleasingW() {
        keyset.keyPressed(new KeyEvent(keyset, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W'));
        keyset.keyReleased(new KeyEvent(keyset, KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W'));
        assert "".equals(keyset.getDirection()) : "Wキーを離した後の方向が正しくない";
    }
}
