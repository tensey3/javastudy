public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnableスレッドが実行されました");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();  // スレッドを開始
    }
}
