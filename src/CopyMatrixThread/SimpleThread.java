package CopyMatrixThread;

public class SimpleThread extends Thread {
    private final int index;
    private final int numberOfThread;
    private final int[][] ar1;
    private final int[][] ar2;
    private final int[][] result;

    public SimpleThread(int i, int numOfThread, int[][] ar1, int[][] ar2, int[][] result) {
        this.index = i;
        this.numberOfThread = numOfThread;
        this.ar1 = ar1;
        this.ar2 = ar2;
        this.result = result;
    }

    @Override
    public void run() {
        for (int r = 0; r < ar1.length; r++) {

            if (r % numberOfThread == index) {
                System.out.println("thread #" +index +" uses row "+ r);
                multipleRowWithColumns(r, ar1[r], ar2, result);
            }
        }
    }

    private void multipleRowWithColumns(int r, int[] row, int[][] ar2, int[][] result) {
        for (int i = 0; i < row.length; i++) {
            System.out.println(" length of second matrix : "+ar2[0].length);
                for (int r2 = 0; r2 < ar2[0].length ; r2++) {
                    System.out.println( " column of result : "+result[0].length);
                    result[r][i] +=(row[i] * ar2[r2][i]);
                    System.out.println(r2);
                }
            System.out.println(" thread : "+currentThread().getName());
        }
    }
}
