import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] list1 = new int[N][M];
        for (int a = 0; a < N; a++) {
            for (int b = 0; b < M; b++) {
                list1[a][b] = sc.nextInt();
            }
        }

        int X = sc.nextInt();

        int[][] list2 = new int[X][2];
        for (int c = 0; c < X; c++) {
            list2[c][0] = sc.nextInt() - 1;
            list2[c][1] = sc.nextInt() - 1;
        }

        sc.close();

        int fare = 0;
        int line = 0;
        int station = 0;

        for (int d = 0; d < X; d++) {
            int nextLine = list2[d][0];
            int nextStation = list2[d][1];

            if (station != nextStation) {
                fare += Math.abs(list1[nextLine][nextStation] - list1[nextLine][station]);
            }

            line = nextLine;
            station = nextStation;
        }

        System.out.println(fare);
    }
}