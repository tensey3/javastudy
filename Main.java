public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 100; i++) {
            sb.append(i);
            if (i < 100) {
                sb.append(",");
            }
        }

        String s = sb.toString();
        System.out.println(s);
        }
    }