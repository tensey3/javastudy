import java.util.ArrayList;

public class CollectionsExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("リンゴ");
        list.add("バナナ");
        list.add("オレンジ");
        
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
