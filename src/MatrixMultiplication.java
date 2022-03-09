import java.util.Scanner;

public class MatrixMultiplication extends Thread{

    static int ar1[][];
    static int ar2[][];
    static int result[][];
    static int n ;
    int row;

    MatrixMultiplication(int i) {
        row = i;
        this.start();
    }

    public void run() {
        int i, j;
        for (i = 0; i < n; i++) {
            result[row][i] = 0;
            for (j = 0; j < n; j++)
                result[row][i] = result[row][i] + ar1[row][j] * ar2[j][i];
        }
    }

    public static void main(String args[]){

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
            System.out.println("columnsOfFirstMatrix ["+ c1 +"] != rowsOfSecondMatrix ["+ r2+ "] ");
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

        MatrixMultiplication mat[] = new MatrixMultiplication[n];
        for (int i = 0; i < n; i++)
            mat[i] = new MatrixMultiplication(i);
            for (int i = 0; i < n; i++)
            {  mat[i].start(); }

        int[][] result= resultMatrix(arr, brr);
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
            System.out.println("columns of first matrix" + c1 + "  is not equal to rows of second matrix " + r2);
        }

        int r1 = arr.length;
        int c2= brr[0].length;
        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 1; k < r2; k++) {
                    sum = sum + arr[i][k] * brr[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

}