public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int result = main.add(5, 3,8); // addメソッドを呼び出し、5と3を渡す
        System.out.println("結果は: " + result); // 結果は: 8 と表示される
    }

    public int add(int a, int b,int v) {
        return a + b; // 足し算の結果を返す
    }
}