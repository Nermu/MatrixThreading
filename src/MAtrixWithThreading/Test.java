package MAtrixWithThreading;

import java.util.Scanner;


public class Test extends Thread{

    static int[][] ar1, ar2, result;
    static int x;
    int row;

    public Test(int row){
        this.row = row;
    }

    @Override
    public void run(){
        for(int i = 0; i < x; i++){
            result[row][i] = 0;
            for(int j = 0; j < x;j++){
                result[row][i] += ar1[row][j] * ar2[i][j];
            }
        }
    }

    //main method
    public static void main(String[] args) {
        System.out.println("Enter Size of matrix : ");
        x = new Scanner(System.in).nextInt();
        ar1 = new int[x][x];
        ar2 = new int[x][x];
        result = new int[x][x];
        for(int i = 0; i < x;i++){
            for(int j = 0; j < x;j++){
                ar1[i][j] = 1;
                ar2[i][j] = 1;
            }
        }

        for(int i=0;i<x;i++){
            new Test(i).start();

        }
        System.out.println("Result Matrix is: ");
        for(int i = 0; i < x;i++){
            for(int j = 0; j < x;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}