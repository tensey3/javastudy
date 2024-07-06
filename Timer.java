import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import javax.swing.JTextArea;

public class Timer {
    private final JTextArea timerTextArea;
    private final List<Integer> flam;
    private final java.util.Timer timer;

    public Timer(JTextArea timerTextArea) {
        this.timerTextArea = timerTextArea;
        flam = new ArrayList<>();
        flam.add(0); // 最初のカウンターを追加

        timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateCounters();
            }
        }, 0, 17); // 0.017秒ごとに実行
    }

    private void updateCounters() {
        // 最後のカウンターを更新
        int lastIndex = flam.size() - 1;
        flam.set(lastIndex, flam.get(lastIndex) + 1);

        // 99に到達したら新しいカウンターを追加
        if (flam.get(lastIndex) > 99) {
            flam.set(lastIndex, 99); // カウンターを99で固定
            flam.add(1); // 新しいカウンターを1で開始
        }

        // カウンターの表示を更新
        StringBuilder sb = new StringBuilder();
        for (int counter : flam) {
            sb.append(counter).append("\n");
        }
        timerTextArea.setText(sb.toString());
    }
}
