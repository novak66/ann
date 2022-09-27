import java.util.ArrayList;
import java.util.List;

public class main {

    public static void main(String args[]) {
        List<Double> x = new ArrayList<>();
        x.add(1.142);
        x.add(2.62);
        x.add(5.066);

        List<Double> y = new ArrayList<>();

        y.add(4.866);
        y.add(4.269);
        y.add(2.206);

        vanderonde(x, y);
    }

    public static void gauss(List<List<Double>> mat ) {


        System.out.println(mat);
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

            if (A.size() == 0) {
                List<Double> row2 = new ArrayList<>();

                for (Double item : row) {
                    row2.add(item);
                }

                A.add(row2);
            } else {

                for (int j = 0; j < row.size(); j++) {
                    A.get(i).add(row.get(j));
                }
                i++;
            }
        }

        System.out.println(A);
    }
}
