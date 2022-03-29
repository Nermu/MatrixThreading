package MatrixFixedThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixFixedThread {

    private final static int NUM_OF_THREAD = 2;

    public static void main(String[] args) {
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

        System.out.println("Insert elements for first matrix : ");
        fillMatrix(input, r1, c1, ar1);

        System.out.println("Insert elements for second matrix : ");
        fillMatrix(input, r2, c2, ar2);

        int[][] result = new int[r1][c2];

        threadStart( r1, ar1, ar2, result);

        System.out.println();

        System.out.println("Result Matrix : ");
        printResultMatrix(result);
    }

    static void fillMatrix(Scanner input, int r1, int c1, int[][] ar1) {
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                ar1[i][j] = input.nextInt();
            }
        }
        System.out.println();
    }

    static void printResultMatrix(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void threadStart(int r1, int[][] ar1, int[][] ar2, int[][] result){
        int numRowForThread , startRow;
        startRow = 0;

        FixedThread[] t = new FixedThread[NUM_OF_THREAD];
        List<FixedThread> threads = new ArrayList<>(NUM_OF_THREAD);

        for (int j = 0; j < NUM_OF_THREAD; j++) {
            if (j < NUM_OF_THREAD - 1) {
                numRowForThread = (r1 / NUM_OF_THREAD);
            } else {
                numRowForThread = (r1 / NUM_OF_THREAD) + (r1 % NUM_OF_THREAD);
            }
            t[j] = new FixedThread( startRow, startRow + numRowForThread, ar1, ar2, result);
            threads.add(t[j]);
            t[j].start();
            startRow += numRowForThread;
            System.out.println("Thread : " + j);
        }

        System.out.println("There is only " + threads.size() + " threads are used.."
                + "\nand "+ r1 + " rows are used...");
        System.out.println();

        for (FixedThread matrixThread : threads) {
            try {
                matrixThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}