// カスタム例外クラスの定義
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
}

public class CustomExceptionExample {
    public static void main(String[] args) {
        try {
            checkValue(5);
        } catch (CustomException e) {
            System.out.println("カスタム例外: " + e.getMessage());
        }
    }

    public static void checkValue(int value) throws CustomException {
        if (value < 10) {
            throw new CustomException("値が小さすぎます: " + value);
        }
    }
}
