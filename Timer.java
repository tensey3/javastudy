import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Timer {
    private final JTextArea timerTextArea;
    private final List<Integer> flam;
    private final javax.swing.Timer swingTimer;

    public Timer(JTextArea timerTextArea) {
        this.timerTextArea = timerTextArea;
        this.flam = new ArrayList<>();
        this.flam.add(0); // ファーストカウンターを追加

        swingTimer = new javax.swing.Timer(17, e -> SwingUtilities.invokeLater(this::updateCounters));
        swingTimer.start();
    }

    private void updateCounters() {
        incrementLastCounter();
        resetCounterIfNeeded();
        updateTextArea();
    }

    private void incrementLastCounter() {
        int lastIndex = flam.size() - 1;
        flam.set(lastIndex, flam.get(lastIndex) + 1);
    }

    private void resetCounterIfNeeded() {
        int lastIndex = flam.size() - 1;
        if (flam.get(lastIndex) > 99) {
            flam.set(lastIndex, 99);
            flam.add(1);
        }
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();//じょじじょうじ
        for (int counter : flam) {
            sb.append(counter).append("\n");
        }
        timerTextArea.setText(sb.toString());
    }
}
