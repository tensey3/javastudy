
public class Main {

public static void main(String[] args) {

int rn = new java.util.Random().nextInt(4);

short a = (short) rn;

int  omikuzi = a;
if (3 > a){
    System.err.println("負け");
    else {
        System.err.println("勝ち");
    }

}


System.out.println(rn);

}
}

