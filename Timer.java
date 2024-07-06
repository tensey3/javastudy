import java.util.Scanner;

public class Timer {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enterキーを押すとタイマーが開始します。");
            scanner.nextLine();  // ユーザーの入力を待つ
        }

        long startTime = System.currentTimeMillis();

        System.out.println("タイマー開始！Ctrl+Cで停止します。");

        while (true) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - startTime;
            System.out.println(elapsedTime + "ミリ秒経過");
            try {
                Thread.sleep(1);  // 1ミリ秒待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}