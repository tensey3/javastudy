import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int H = scanner.nextInt();
        int W = scanner.nextInt();
        scanner.nextLine(); 
        
        char[][] matrix = new char[H][W];
        
        for (int i = 0; i < H; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
        }
        
        int maxArea = 0;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (matrix[i][j] == '.') {
                   
                    int minWidth = W;
                    for (int k = i; k < H && matrix[k][j] == '.'; k++) {
                        int width = 0;
                        while (j + width < W && matrix[k][j + width] == '.') {
                            width++;
                        }
                        if (width < minWidth) {
                            minWidth = width;
                        }
                        int height = k - i + 1;
                        int area = minWidth * height;
                        if (area > maxArea) {
                            maxArea = area;
                        }
                    }
                }
            }
        }
        
        System.out.println(maxArea);
        
        scanner.close();
    }
}