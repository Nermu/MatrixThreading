package CopyMatrixThread;

import static CopyMatrixThread.MatMultiplication.result;

public class MatrixFixedThread extends Thread {
    private int startRow, stopRow;
    private Matrix matA, matB;

    public MatrixFixedThread(int startRow, int stopRow, Matrix matA, Matrix matB) {
        super();
        this.startRow = startRow;
        this.stopRow = stopRow;
        this.matA = matA;
        this.matB = matB;
    }

    @Override
    public void run() {
        for (int i = startRow; i < stopRow; i++) {
            for (int j = 0; j < matB.getNColumns(); j++) {
                double sum = 0;
                for (int k = 0; k < matA.getNColumns(); k++) {
                    sum += matA.get(i, k) * matB.get(k, j);
                }
                result.set(i, j, sum);
            }
        }
    }
}
