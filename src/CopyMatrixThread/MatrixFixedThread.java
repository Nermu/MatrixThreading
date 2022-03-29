package CopyMatrixThread;

public class MatrixFixedThread extends Thread {
    private int row;
    private int[][] ar1;
    private int[][] ar2;
    private int[][] result;

    public MatrixFixedThread(int row, int[][] ar1, int[][] ar2, int[][] result) {
        super();
        this.row = row;
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.result = result;
    }

    @Override
    public void run() {
        while (true){

            int i, j;
            for (i = 0; i < ar2[0].length; i++) {// ar2[0].length -> num of col(value of elements)
                result[row][i] = 0;
                for (j = 0; j < ar1[0].length; j++) { // ar1[0].length -> num of col
                    result[row][i] += ar1[row][j] * ar2[j][i];
                }
            }
            System.out.println("Thread : " + currentThread().getName());

            break;
        }
       }
}
