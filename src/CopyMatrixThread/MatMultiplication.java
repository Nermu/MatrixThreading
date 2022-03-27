package CopyMatrixThread;

public class MatMultiplication {
    private final static int NUM_OF_THREAD = 3;
    public static Matrix result;

    public static Matrix matrixMul(Matrix arr1, Matrix arr2) {
        result = new Matrix(arr1.getNRows(), arr2.getNColumns());
        return mul(arr1, arr2);
    }

    private static Matrix mul(Matrix arr1, Matrix arr2) {
        int numRowForThread;
        int numRowA = arr2.getNRows();
        int startRow = 0;

        MatrixFixedThread[] threads = new MatrixFixedThread[NUM_OF_THREAD];

        for (int j = 0; j < NUM_OF_THREAD; j++) {
            if (j < NUM_OF_THREAD - 1) {
                numRowForThread = (numRowA / NUM_OF_THREAD);
            } else {
                numRowForThread = (numRowA / NUM_OF_THREAD) + (numRowA % NUM_OF_THREAD);
            }
            threads[j] = new MatrixFixedThread(startRow, startRow + numRowForThread, arr1, arr2);
            threads[j].start();
            startRow += numRowForThread;
        }

        for (MatrixFixedThread matrixThread : threads) {
            try {
                matrixThread.join();
            } catch (InterruptedException e) {

            }
        }
        return result;
    }




   }