
public class Main {

public static void main(String[] args) {

int rn = new java.util.Random().nextInt(4);

short a = (short) rn;

boolean tenki = true;

if (tenki == true){
    System.err.println("今日は晴れなので外で服を干します");
}
else{
    System.err.println("雨なので今日は家で映画見ます");
}

}
}
