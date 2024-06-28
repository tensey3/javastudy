public class Dog {
    // フィールド（クラスの属性）
    String name;
    int agea;

    // コンストラクタ（クラスの初期化メソッド）
    public Dog(String name, int age) {
        this.name = name;
        this.agea = age;
    }

    // メソッド（クラスの動作）
    public void bark() {
        System.out.println(name + "が吠えました");
    }
}

