// public class Main {
//     public static void main(String[] args) {
//         Main main = new Main();
//         int result = main.add(5, 3,8); // addメソッドを呼び出し、5と3を渡す
//         System.out.println("結果は: " + result); // 結果は: 8 と表示される
//         int a = 5;
//         int b = 8;
//         int c = a++ + ++b - --a;
//         int d = ++a;
//         int y = a++;
//         int z = a++ + ++ a;
//         int dd = --a;
//         int yy = a--;
//         int zz =a-- - --a;
//     System.err.println(c);
//     System.err.println(d);
//     System.err.println(y);
//     System.err.println(z);
//     System.err.println(dd);
//     System.err.println(yy);
//     System.err.println(zz);
//     }
//     public int add(int a, int b,int v) {
//         return a + b;
//     }
// }
// import java.util.ArrayList;
// import java.util.Map;
// import java.util.TreeMap;
// import java.util.TreeSet;

// public class Main {
//     public static void main(String[] args) {
//         // ArrayListの作成
//         ArrayList<Hero> heroes = new ArrayList<>();
//         Map<String, TreeSet<String>> pecialtiesForPrefs = new TreeMap<>();

//         // Heroのインスタンス化とArrayListへの追加
//         heroes.add(new Hero("斎藤"));
//         heroes.add(new Hero("鈴木"));

//         // ArrayListから1人ずつ取り出して名前を表示
//         for (Hero hero : heroes) {
//             System.out.println("勇者の名前: " + hero.getName());
//         }
//     }
// }

// class Hero {
//     private String name;

//     public Hero(String name) {
//         this.name = name;
//     }

//     public String getName() {
//         return this.name;
//     }
// }