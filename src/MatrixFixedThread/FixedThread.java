package MatrixFixedThread;

public class FixedThread extends Thread {
    private int startRow, stopRow;
    private int[][] ar1;
    private int[][] ar2;
    private int[][] result;

    public FixedThread(int startRow, int stopRow, int[][] ar1, int[][] ar2, int[][] result) {
        super();
        this.startRow = startRow;
        this.stopRow = stopRow;
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.result = result;
    }

    @Override
    public void run() {

        int k, i, j;
        for (k = startRow; k < stopRow; k++){
            for (i = 0; i < ar2[0].length; i++) {// ar2[0].length -> num of col(value of elements)
                result[k][i] = 0;
                for (j = 0; j < ar1[0].length; j++) { // ar1[0].length -> num of col
                    result[k][i] += ar1[k][j] * ar2[j][i];
                }
            }
        }
        System.out.println("Thread : " + currentThread().getName());
    }
}
