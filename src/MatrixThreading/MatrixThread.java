package MatrixThreading;

class MatrixThread extends Thread {
    private int[][] ar1;
    private int[][] ar2;
    private int[][] result;
    private int row, col;
    private int dim;

    public MatrixThread(int[][] ar1, int[][] ar2, int[][] result, int row, int col, int dim_com) {
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.result = result;
        this.row = row;
        this.col = col;
        this.dim = dim_com;
    }

    public void run() {
        for (int i = 0; i < dim; i++) {
            result[row][col] += ar1[row][i] * ar2[i][col];
        }
        System.out.println("Thread " + row + "," + col + " complete.");
    }
}