public class MyThread extends Thread {
    public void run() {
        System.out.println("スレッドが実行されました");
    }

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();  // スレッドを開始
    }
}
