package MAtrixWithThreading;

import java.util.Scanner;

public class MatrixMultiplyThread implements Runnable{

    static int[][] A,B,C;
    static int x;
    int row;

    public MatrixMultiplyThread(int row){
        this.row=row;
    }

    @Override
    public void run(){
        for(int a=0;a<x;a++){
            C[row][a]=0;
            for(int b=0;b<x;b++){
                C[row][a]+=A[row][b]*B[b][a];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Please Enter Size of Matrix");
        x= new Scanner(System.in).nextInt();
        A= new int[x][x];
        B= new int[x][x];
        C= new int[x][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<x;j++){
                A[i][j]=1;
                B[i][j]=1;
            }
        }

        for(int i=0;i<x;i++){
            new MatrixMultiplyThread(i).run();
        }

        System.out.println("The Result is: ");

        for(int i=0;i<x;i++){
            for(int j=0;j<x;j++){
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
    }

}
