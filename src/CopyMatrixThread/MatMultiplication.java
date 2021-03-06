package CopyMatrixThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatMultiplication {
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

        MatrixFixedThread[] t = new MatrixFixedThread[NUM_OF_THREAD];
        List<MatrixFixedThread> threads = new ArrayList<>(NUM_OF_THREAD);

        if (r1 <= NUM_OF_THREAD){
            for (int i = 0; i < r1; i++) {
                t[i] = new MatrixFixedThread(i , ar1, ar2, result);
                threads.add(t[i]);
                t[i].start();
                System.out.println("Thread : " + i);
            }
            System.out.println("There is only " + threads.size() + " threads are used..");
            System.out.println();
            for (int i = 0; i < r1; i++) {
                try {
                    t[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (r1 > NUM_OF_THREAD) {
            for (int i = 0; i < r1  ; i++) {
                if( i < NUM_OF_THREAD){
                    threads.add(new MatrixFixedThread(i,ar1,ar2,result));
                    threads.get(i).start();
                    System.out.println("Thread : " + i);
                    System.out.println();
                }
                else if (i >= NUM_OF_THREAD){
                    if (i % NUM_OF_THREAD != 0) {
                        int var = (i % NUM_OF_THREAD);
                        System.out.println("value of Var : " + var);
                        try {
                            threads.get(var).join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        threads.get(var).start();
                       System.out.println("Thread : " + i);
                       System.out.println();
                    }
                    else if (i % NUM_OF_THREAD == 0) {
                        int var = NUM_OF_THREAD;
                        System.out.println("value of Var : " + var);
                        try {
                            threads.get(var - 1).join();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        threads.get(var - 1).start();
                        System.out.println("Thread : " + i);
                        System.out.println();
                    }
                    System.out.println("There is only " + threads.size() + " threads are used.."
                            + "\nbecause number of row > number of threads");
                }
            }

        }
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