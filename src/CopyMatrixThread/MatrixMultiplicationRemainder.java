package CopyMatrixThread;

import java.util.Scanner;

public interface MatrixMultiplicationRemainder {
    int NUM_OF_THREAD = 3;

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert size of first matrix :  ");
        int r1 = input.nextInt();
        int c1 = input.nextInt();
        System.out.println("Insert size of second matrix :  ");
        int r2 = input.nextInt();
        int c2 = input.nextInt();
        System.out.println();

        if (c1 != r2) {
            System.out.println("We can't do the matrix product!");
            System.exit(-1);
        }
        System.out.println("The matrix result from product will be " + r1 + " x " + c2);
        int[][] ar1 = new int[r1][c1];
        int[][] ar2 = new int[r2][c2];

        fillMatrix(input, r1, c1, ar1);
        fillMatrix(input, r2, c2, ar2);

        int[][] result = new int[r1][c2];
        SimpleThread[] t = new SimpleThread[NUM_OF_THREAD];
        for (int i = 0; i < NUM_OF_THREAD; i++) {
            t[i] = new SimpleThread(i, NUM_OF_THREAD, ar1, ar2, result);
            t[i].start();
            t[i].join();
        }
        printMatrix(result);
    }

    static void printMatrix(int[][] result) {
        for (int i = 0; i <result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(" " + result[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner input, int r1, int c1, int[][] ar1) {
        System.out.println("Insert elements for matrix : ");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                ar1[i][j] = input.nextInt();
            }
        }
        System.out.println();
    }
}

