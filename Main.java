public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            sb.append(i);
            if (i < 100) {
                sb.append(",");
            }
        }
        sb.append(".");

        String s = sb.toString();
        System.out.println("生成された文字列: " + s);

        String[] stringArray = s.substring(0, s.length() - 1).split(",");

        System.out.println("String 配列:");
        }
    }