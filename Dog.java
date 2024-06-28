public class Dog {
    // フィールド（クラスの属性）
    String name;
    int age;

    // コンストラクタ（クラスの初期化メソッド）
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // メソッド（クラスの動作）
    public void bark() {
        System.out.println(name + "が吠えました");
    }
}

public class Main {
    public static void main(String[] args) {
        // オブジェクトの作成
        Dog myDog = new Dog("ポチ", 3);
        myDog.bark();
    }
}
