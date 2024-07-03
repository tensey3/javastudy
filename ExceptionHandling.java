public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            // リスクのあるコード
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            // 例外が発生した場合の処理
            System.out.println("エラー: 0で割ることはできません");
        }
    }
}
