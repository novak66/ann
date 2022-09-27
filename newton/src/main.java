import java.util.Locale;

public class main {

    public static Double dFunction1(Double x) {
        return (Math.exp(x) - (4 * x) + 1);
    }

    public static Double dFunction2(Double x) {
        return (Math.PI - Math.exp(x));
    }

    public static Double dFunction3(Double x) {
        return (1 - ((-1) * Math.log(2) * Math.pow(2, (-1 * x))));
    }

    public static Double dFunction4(Double x) {
        return (Math.exp(5 * x) * 5);
    }

    public static Double dFunction5(Double x) {
        return ((3 * Math.pow(x, 2)) - 6 * x + 2);
    }

    public static Double function1(Double x) {
        return (Math.exp(x) - (2 * Math.pow(x, 2)) + x - 1.5);
    }

    public static Double function2(Double x) {
        return ((Math.PI * x) - Math.exp(x));
    }

    public static Double function3(Double x) {
        return (x - Math.pow(2, (-1 * x)));
    }

    public static Double function4(Double x) {
        return (Math.exp(5 * x) - 2);
    }

    public static Double function5(Double x) {
        return ((x * (x - 1) * (x - 2)) + 0.42);
    }

    public static void main(String args[]) {
        segundoMetodoNewton();
    }

    public static void primeiroMetodoNewton() {
        Double x0 = 2.87217967;
        for (int i = 0; i < 200; i++) {
            Double dfX0 = dFunction5(x0);
            Double fX0 = function5(x0);
            Double xi = (x0 - (fX0 / dfX0));

            if (((i + 1) % 5 == 0))
                System.out.printf("%.10f, ", xi);
            x0 = xi;
        }
    }

    public static Double f1(Double x, Double y) {
        return Math.pow(x, 2) +  Math.pow(y, 2) -5;
    }

    public  static Double f2(Double x, Double y) {
        return Math.pow(x, 2) + (x*Math.pow(y, 3)) - 3;
    }

    public static Double f1x(Double x, Double y) {
        return 2*x;
    }

    public static Double f1y(Double x, Double y) {
        return 2*y;
    }

    public  static Double f2x(Double x, Double y) {
        return 2*x + (y*y*y);
    }

    public  static Double f2y(Double x, Double y) {
        return 3*(y*y)*x;
    }

    public static void segundoMetodoNewton() {
        Double x0 = -2.1192;
        Double y0 = 1.2752;
        Locale.setDefault(Locale.US);
        for (int i = 0; i < 5; i++) {
            Double a = f1x(x0, y0);
            Double b = f1y(x0, y0);
            Double c = f2x(x0, y0);
            Double d = f2y(x0, y0);

            Double det = (a * d) - (b * c);

            Double xk = x0 - (f2y(x0, y0) * f1(x0, y0) - f1y(x0, y0) * f2(x0, y0)) / det;
            Double yk = y0 - ((-1 * f2x(x0, y0)) * f1(x0, y0) + f1x(x0, y0) * f2(x0, y0)) / det;
            x0 = xk;
            y0 = yk;

            System.out.printf("%.16f, %.16f", x0, y0);
            System.out.println(",");
        }
    }
}
