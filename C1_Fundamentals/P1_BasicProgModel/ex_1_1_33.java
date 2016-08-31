public class ex_1_1_33 {
    public static void main(String[] args) {

    }

    public double dot(double[] x, double[] y) {//vector dot product
        if (x.length != y.length) {
            throw new IllegalArgumentException("not same size");
        }
        double rt = 0.0;
        for (int i = 0; i < x.length; i++) {
            rt += x[i] * y[i];
        }
        return rt;
    }

    public double[][] mult(double[][] a, double[][] b) {//matrix-matrix product
        if (a[0].length != b.length)
            throw new IllegalArgumentException();
        double[][] rt = new double[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int k = 0; k < b[0].length; i++)
                    rt[i][k] += a[i][j] * b[j][k];
            }
        }
        return rt;
    }

    public double[][] transpose(double[][] a) {//transpose
        double[][] transpose = new double[a[0].length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                transpose[j][i] = a[i][j];
            }
        }
        return transpose;
    }

    public double[] mult(double[][] a, double[] x) {//matrix-vector product
        if (a[0].length != x.length)
            throw new IllegalArgumentException();
        double[] rt = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                rt[i] += a[i][j] * x[j];
            }
        }
        return rt;
    }

    public double[] mult(double[] y, double[][] a) {//vector-matrix product
        if (y.length != a.length)
            throw new IllegalArgumentException();
        double[] rt = new double[y.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                rt[i] += a[i][j] * y[j];
            }
        }
        return rt;
    }
}