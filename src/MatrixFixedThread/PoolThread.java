package MatrixFixedThread;

import MatrixThreading.MatrixThread;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PoolThread {
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
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                ar1[i][j] = input.nextInt();
            }
        }
        System.out.println();

        System.out.println("Insert elements for second matrix : ");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                ar2[i][j] = input.nextInt();
            }
        }
        System.out.println();

        int[][] result = new int[r1][c2];

        MatrixThread[] t = new MatrixThread[r1];

        ExecutorService pool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < r1; i++) {
            pool.submit(new MatrixThread(ar1, ar2, result, i, c2));
        }
        pool.shutdown();
        try {
            pool.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        /*for (int i = 0; i < r1; i++) {
            t[i] = new MatrixThread(ar1, ar2, result, i, c2);
            t[i].start();
        }
        System.out.println();
        for (int i = 0; i < r1; i++) {
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

        System.out.println();
        System.out.println("Result Matrix : ");
        for (int i = 0; i < ar1.length; i++) {
            for (int j = 0; j < ar2[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}