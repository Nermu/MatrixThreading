package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class LargeMatrices {
    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[][] = fillArray(n);
        int b[][] = fillArray(n);

        multiplyMatrix(a , b, n);
    }

    public static int[][] fillArray(int n){
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++){
            Arrays.fill(arr[i],1);
        }
        return arr;
    }

    public static int[][] multiplyMatrix(int[][] a, int[][] b, int n){

        int[][] result = fillArray(n);

        for (int i = 0; i < fillArray(n).length; i++) {
            for (int j = 0; j < fillArray(n).length; j++) {
                result[i][j] = 0;
                for (int k = 0; k < fillArray(n).length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        return result;

    }

}
