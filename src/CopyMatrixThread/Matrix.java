package CopyMatrixThread;
public class Matrix {
    private double[][] mat;

    public Matrix(int n, int m) {
        mat = new double[n][m];
    }

    public void set(int i, int j, double v) {
        mat[i][j] = v;
    }

    public double get(int i, int j) {
        return mat[i][j];
    }

    public int getNRows() {
        return mat.length;
    }

    public int getNColumns() {
        return mat[0].length;
    }
}