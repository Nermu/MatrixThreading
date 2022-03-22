package MatrixFixedThread;

public class FixedThread extends Thread {

    private volatile boolean isBusy;

    private int[][] ar1;
    private int[][] ar2;
    private int[][] result;
    private int row, col;

    public FixedThread(int[][] ar1, int[][] ar2, int[][] result, int row, int col) {
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.result = result;
        this.row = row;
        this.col = col;
        this.isBusy = true;
    }

    public boolean isBusy() {
        return isBusy;
    }
    @Override
    public void run() {
            int i, j;
            for (i = 0; i < ar2[0].length; i++) {// ar2[0].length -> num of col(value of elements)
                result[row][i] = 0;
                for (j = 0; j < ar1[0].length; j++) { // ar1[0].length -> num of col
                    result[row][i] += ar1[row][j] * ar2[j][i];
                }
            }
            System.out.println("isBusy " + isBusy);

        isBusy = false;
        System.out.println("isBusy " + isBusy);
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
