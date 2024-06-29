public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int result = main.add(5, 3,8); // addメソッドを呼び出し、5と3を渡す
        System.out.println("結果は: " + result); // 結果は: 8 と表示される
        int a = 5;
        int b = 8;
        int c = a++ + ++b - --a;
        int d = ++a;
        int y = a++;
        int z = a++ + ++ a;
        int dd = --a;
        int yy = a--;
        int zz =a-- - --a;
    System.err.println(c);
    System.err.println(d);
    System.err.println(y);
    System.err.println(z);
    System.err.println(dd);
    System.err.println(yy);
    System.err.println(zz);
    }

    public int add(int a, int b,int v) {
        return a + b;
    }
}