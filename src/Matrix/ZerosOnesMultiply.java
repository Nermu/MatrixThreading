package Matrix;

import java.util.Scanner;

public class ZerosOnesMultiply{

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of first matrix");

        int r1 = input.nextInt();
        int c1 = input.nextInt();
        int[][] arr = new int[r1][c1];

        System.out.println("Enter the elements of first matrix");
        for (int i = 0; i < r1;  i++) {
            for (int j = 0; j < c1; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        System.out.println("Enter the number of rows and columns of the second matrix");
        int r2 = input.nextInt();
        int c2 = input.nextInt();

        // multiplication or not
        while (c1 != r2) {
            System.out.println("Matrices with entered orders can't be multiplied with each other, "
                    + "columnsOfFirstMatrix ["+ c1 +"] != rowsOfSecondMatrix ["+ r2+ "] ");
            System.out.println("Enter the number of rows and columns of second matrix");
            r2 = input.nextInt();
            c2 = input.nextInt();
        }

        int[][] brr = new int[r2][c2];
        System.out.println("Enter numbers of second matrix");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                brr[i][j] = input.nextInt();
            }
        }

        // calculating result of two matrices
        int[][] result = resultMatrix(arr, brr);
        System.out.println("Result of entered matrices:-");

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2 ; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        input.close();
    }

    public static int[][] resultMatrix(int[][] arr, int[][] brr) {
        int c1 = arr[0].length;
        int r2 = brr.length;

        if (c1 != r2) {
            System.out.println("Can't multiply matrices, columns of first matrix"
                    + c1 + "  is not equal to rows of second matrix " + r2);
        }

        int r1 = arr.length;
        int c2 = brr[0].length;
        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {

                int sum = 0;
                for (int k = 0; k < r2; k++) {
                    sum = sum + arr[i][k] * brr[k][j];
                }

                result[i][j] = sum;
            }
        }

        return result;
    }

}