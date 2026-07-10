package J04;

import java.util.Scanner;

public class J04016 {
    static class Matrix{
        int x, y;
        int[][] matrix;

        public Matrix(int x, int y) {
            this.x = x;
            this.y = y;
            this.matrix = new int[x][y];
        }

        public void nextMatrix(Scanner sc){
            for (int i = 0; i < this.x; i++){
                for (int j = 0; j < this.y; j++){
                    this.matrix[i][j] = sc.nextInt();
                }
            }
        }

        public String mul(Matrix other){
            int n = this.x;
            int m = this.y;
            int p = other.y;

            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < n; i++){
                for (int j = 0; j < p; j++){
                    int sum = 0;
                    for (int k = 0; k < m; k++){
                        sum += this.matrix[i][k] * other.matrix[k][j];
                    }
                    stringBuilder.append(sum).append(" ");
                }
                stringBuilder.deleteCharAt(stringBuilder.length()-1)
                        .append("\n");
            }

            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
        Matrix a = new Matrix(n,m);
        a.nextMatrix(sc);
        Matrix b = new Matrix(m,p);
        b.nextMatrix(sc);
        System.out.println(a.mul(b));
    }
}
