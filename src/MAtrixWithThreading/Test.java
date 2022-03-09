package MAtrixWithThreading;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Test extends Thread {
    //Multiplying two matrices using thread on row

    static int ar1[][];
    static int ar2[][];
    static int result[][];
    static int n = 4;
    int row;

    Test(int i) {
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

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the order of Matrix : ");
        try {
            n = 4;
        } catch (Exception e) {
        }

        ar1 = new int[n][n];
        ar2 = new int[n][n];
        result = new int[n][n];

        System.out.println("Enter the elements of first matrix :  ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                try {
                    ar1[i][j] = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                }
            }
        }

        System.out.println("Enter the elements of second matrix :  ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                try {
                    ar2[i][j] = Integer.parseInt(br.readLine());
                } catch (Exception e) {
                }
            }
        }

        Test mat[] = new Test[n];
        for (int i = 0; i < n; i++)
            mat[i] = new Test(i);
        try {
            for (int i = 0; i < n; i++)
                mat[i].join();
        } catch (Exception e) {
        }

        System.out.println("Result of entered matrices :- ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

