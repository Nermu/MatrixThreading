package MatrixFixedThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyFixedThread {

    private static final int NO_THREADS = 5;
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
        List<FixedThread> threadArr = new ArrayList<FixedThread>(NO_THREADS);



        //FixedThread[] t = new FixedThread[threadArr.size()];

//        threadArr.add(new FixedThread(ar1, ar2, result, r1, c2));
//        threadArr.add(new FixedThread(ar1, ar2, result, r1, c2));
//        threadArr.add(new FixedThread(ar1, ar2, result, r1, c2));
//        threadArr.add(new FixedThread(ar1, ar2, result, r1, c2));
//        threadArr.add(new FixedThread(ar1, ar2, result, r1, c2));

        for(int i = 0 ; i <NO_THREADS ; i++){

        }

        System.out.println(threadArr.size());
        if (r1 < threadArr.size()){
            for (int i = 0; i < r1; i++) {

                threadArr.add(new FixedThread(ar1,ar2,result,i,c2));
                threadArr.get(i).start();
                System.out.println("Thread : " + i);
            }
            System.out.println();

            for (int i = 0; i < r1; i++) {
                try {
                    threadArr.get(i).join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        /*else if (r1 == threadArr.size()){
            for (int i = 0; i < threadArr.size(); i++) {
                t[i] = new FixedThread(ar1, ar2, result, i, c2);
                t[i].start();
                System.out.println("Thread : " + i);
            }
            System.out.println();

            for (int i = 0; i < threadArr.size(); i++) {
                try {
                    t[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        else if (r1 > threadArr.size()) {
            System.out.println("----Out of Bounds----");
                for (int i = 0; i < r1; i++) {
                        t[i] = new FixedThread(ar1, ar2, result, i, c2);
                        t[i].start();
                }
                System.out.println();

                for (int i = 0; i < r1; i++) {
                    try {
                        t[i].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
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
/*
*
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
* */
/*
1 1 1 1 1 1
1 1 1 1 1 1
1 1 1 1 1 1
1 1 1 1 1 1
1 1 1 1 1 1
* */