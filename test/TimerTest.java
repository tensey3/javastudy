package test;

import javax.swing.JTextArea;
import src.Timer;

public class TimerTest {
    private Timer timer;
    private JTextArea textArea;

    public static void main(String[] args) {
        TimerTest test = new TimerTest();
        test.setUp();
        test.testInitialCounterIsZero();
        test.testCounterIncrements();
        System.out.println("すべてのテストが成功しました。");
    }

    public void setUp() {
        textArea = new JTextArea();
        timer = new Timer(textArea);
    }

    public void testInitialCounterIsZero() {
        assert "0\n".equals(textArea.getText()) : "初期カウンタが0でない";
    }

    public void testCounterIncrements() {
        try {
            Thread.sleep(20); // 少し待機してタイマーが動作する時間を与える
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert !textArea.getText().isEmpty() : "カウンタが増加しない";
    }
}
