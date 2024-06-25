import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        
        
        int N = s.nextInt();
        int M = s.nextInt();
        int K = s.nextInt();
        int[] usagichan = new int[M];
        for (int i = 0; i < M; ++i) {
            usagichan[i] = s.nextInt();
        }
        s.close();
        boolean[] occupied = new boolean[N + 1];
        for (int i = 0; i < M; ++i) {
            occupied[usagichan[i]] = true;
}
        for (int i = 1; i <= K; ++i) {
            for (int j = 0; j < M; ++j) {
                int currentBush = usagichan[j];
                int nextBush = currentBush % N + 1;
                while (occupied[nextBush]) {
                    nextBush = nextBush % N + 1;
                }
                usagichan[j] = nextBush;
                occupied[currentBush] = false;
                occupied[nextBush] = true;
            }
    }
        for (int i = 0; i < M; ++i) {
            System.out.println(usagichan[i]);
        }
    }
}
