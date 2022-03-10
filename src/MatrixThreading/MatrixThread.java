package MatrixThreading;

class MatrixThread extends Thread {
    private int[][] ar1;
    private int[][] ar2;
    private int[][] result;
    private int row, col;
    private int dim;

    public MatrixThread(int[][] ar1, int[][] ar2, int[][] result, int row, int col, int dim ) {
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.result = result;
        this.row = row;
        this.col = col;
        this.dim = dim;
    }

    @Override
    public void run() {
        int i, j;
        for ( i = 0; i < dim; i++) {
            result[row][i] = 0;
            for ( j = 0; j < dim; j++)
                result[row][i] += ar1[row][j] * ar2[j][i];
        }
        System.out.println("Thread " + row + "," + col + " complete.");
    }
}
