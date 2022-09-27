import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class main {

    public static void main(String args[]) {
        List<Double> x = new ArrayList<>();
        x.add(0.456);
        x.add(0.974);
        x.add(1.557);
        x.add(2.16);
        x.add(2.662);
        x.add(3.146);
        x.add(3.571);
        x.add(4.198);
        x.add(5.164);
        x.add(5.719);
        x.add(6.312);
        x.add(6.865);
        List<Double> y = new ArrayList<>();

        y.add(4.433);
        y.add(4.796);
        y.add(4.919);
        y.add(4.676);
        y.add(4.225);
        y.add(3.666);
        y.add(3.159);
        y.add(2.542);
        y.add(2.211);
        y.add(2.375);
        y.add( 2.701);
        y.add( 2.979);
        vanderonde(x, y);
    }

    public static double[] solveSystem(List<List<Double>> A, List<Double> b) {
        double[] x = initialize(new double[A.get(0).size()]);
        for (int k = 0; k < 100000000; k++) {
            for (int i = 0; i < A.size(); i++) {
                double x0 = 0;
                for (int j = 0; j < A.size(); j++)
                    if (i != j)
                        x0 += A.get(i).get(j) * x[j];
                x[i] = (b.get(i) - x0)/A.get(i).get(i);
            }
        }
        return x;
    }

    private static double[] initialize(double[] output) {
        for (int i = 0; i < output.length; i++)
            output[i] = 0;
        return output;
    }


    public static void multiplicar(List<List<Double>> mat, List<Double> B) {
        int i = 0;
        List<Double> coefs = new ArrayList<>();
        Double sum = 0.0;
        for (List<Double> items : mat) {
            for (Double item : items) {
                sum += item * B.get(i);
            }
            i++;
            coefs.add(sum);
            sum = 0.0;
        }

        System.out.println(coefs);
    }

    //retorna os coeficientes do polinomio interpolador
    public static void vanderonde(List<Double> x, List<Double> y) {
        List<Double> B = new ArrayList<>();
        List<Double> row = new ArrayList<>();
        for (Double item : y) {
            B.add(item);
            row.add(0.0);
        }

        List<List<Double>> A = new ArrayList<>();

        int i=0;
        for (Double xi : x) {
            row.set(0, 1.0);
            for (int k = 1; k < x.size(); k++) {
                row.set(k, Math.pow(xi, k));
            }

            preencherMatr(A, row);
        }

      double[] coesf =   solveSystem(A, B);
        Locale.setDefault(Locale.US);
        for(int k=0; k< coesf.length; k++) {
            System.out.printf("%.16f, ", coesf[k]);
        }
    }

    public static void preencherMatr(List<List<Double>> A, List<Double> row) {
        List<Double> newRow = new ArrayList<>();

        for(Double item: row) {
            newRow.add(item);
        }

        A.add(newRow);
    }
}
