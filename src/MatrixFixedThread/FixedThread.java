package MatrixFixedThread;

public class FixedThread extends Thread {

    private int[][] ar1;
    private int[][] ar2;
    private int[][] result;
    private int row, col;

    public FixedThread(){};

    public FixedThread(int[][] ar1, int[][] ar2, int[][] result, int row, int col) {
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.result = result;
        this.row = row;
        this.col = col;
    }

    @Override
    public void run() {
        int i, j;
        for (  i = 0; i < ar2[0].length; i++) {// ar2[0].length -> num of col(value of elements)
            result[row][i] = 0;
            for (  j = 0; j < ar1[0].length; j++){ // ar1[0].length -> num of col
                result[row][i] += ar1[row][j] * ar2[j][i];
                //tracing
                //System.out.println("arr1 with row : " + row + " and j : " + j + " is " + ar1[row][j] + " : "+ currentThread().getName());
                //System.out.println("arr2 with j : " + j + " and i : " + i + " is " + ar2[j][i] + " : " + currentThread().getName());
                //System.out.println("result of : " + ar1[row][j] + " * " + ar2[j][i] + " is : " + result[row][i]);
            }
        }
        System.out.println("Thread : " + currentThread().getName());
    }
}
/*
*
1 2 3 4
5 6 7 8
9 1 2 3
*
1 2 3
4 5 6
7 8 9
1 2 3
* */
