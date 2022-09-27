import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class main {

    public static void main(String args[]) {
        List<Double> x = new ArrayList<>();
        x.add(-2.793);
        x.add(-1.705 );
        x.add(-0.557);
        x.add(0.03 );
        x.add(1.225 );
        x.add(1.982);
        x.add(2.985);
        x.add(4.109);
        List<Double> y = new ArrayList<>();

        y.add(func2(-2.793));
        y.add(func2(-1.705));
        y.add(func2(-0.557));
        y.add(func2(0.03));
        y.add(func2(1.225));
        y.add(func2(1.982));
        y.add(func2(2.985));
        y.add(func2(4.109));
        vanderonde(x, y);
    }

    public static Double func(Double x) {
        return  Math.sin(Math.sqrt(1+Math.tan(x)));
    }

    public static Double func2(Double x) {
        return  Math.pow(Math.cos(x), 3) + (2*Math.pow(Math.cos(x), 2)) + 1;

    }


    public static double[] solveSystem(List<List<Double>> A, List<Double> b) {
        double[] x = initialize(new double[A.get(0).size()]);
        for (int k = 0; k < 1000000; k++) {
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
