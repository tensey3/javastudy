
public class Main {

public static void main(String[] args) {

int rn = new java.util.Random().nextInt(4);

for(int i = 0; i < 10; i++){
    
    System.err.println(++i);
}

for (int j = 0; j < 10; j +=2) {
    System.err.println(++j);
}
}
}
