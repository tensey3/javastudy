public class Methods {
    // メインメソッド
    public static void main(String[] args) {
        sayHello();
        int result = addNumbers(5, 3);
        System.out.println("5 + 3 = " + result);
    }

    // メソッドの定義
    public static void sayHello() {
        System.out.println("こんにちは");
    }

    public static int addNumbers(int a, int b) {
        return a + b;
    }
}
