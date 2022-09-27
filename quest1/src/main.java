import java.math.BigDecimal;

public class main {

    public static Double function(Double x) {

        return (Math.exp(x) - (2 * Math.pow(x, 2)) + x - 1.5);
    }

    public static Double functionQuest2(Double x) {
        return Math.sqrt(x) - Math.cos(x);
    }

    public static Double functionQuest3(Double x) {
        return (Math.pow(x, 4) - (2 * Math.pow(x, 3)) - (3 * Math.pow(x, 2)) + (3 * x) + 2);
    }

    public static Double functionQuest4(Double x) {
        return (Math.pow(x, 2) - 3);
    }

    public static BigDecimal functionQuest5(BigDecimal x) {
        BigDecimal UM = new BigDecimal(1);
        BigDecimal ZEROCINCO = new BigDecimal(0.5);
        BigDecimal DOIS = new BigDecimal(2);

        BigDecimal teste = DOIS.multiply((x.add(UM)).multiply((x.subtract(ZEROCINCO))).multiply(x.subtract(UM)));

        return teste;
    }



    public static Double functionQuest6(Double x) {

        Double resu1 = (Math.PI * x);

        Double resu2 = Math.exp(x);

        resu1 = resu1 - resu2;

        return resu1;
    }

    public static Double functionQuest7(Double x) {

        return (Math.exp(x) - (2*Math.pow(x, 2) + x - 1.5));
    }

    public static Double functionQuest8(Double x) {

        return (Math.pow(x, 3) - (7*Math.pow(x, 2) + (14*x) - 7));
    }

    public static Double functionQuest9(Double x) {

        return ((Math.log(Math.pow(x, 2))) - 0.7);
    }

    public static Double functionQuest10(Double x) {

        return (Math.pow(x, 2) - (3.1148*x) + 1.3539);
    }

    public static void main(String args[]) {
        Double a = 1.8917;
        Double b = 5.2471;
        Double c = 0.00000;
        Double t = 0.00000;

        for (int i = 0; i < 64; i++) {
            c = ((a + b) / 2);
            t = ((b - a) / 2);

            Double funcC = functionQuest10(c);
            Double funcT = functionQuest10(t);


            Double funcA = functionQuest10(a);

            Double funcB = functionQuest7(b);

            System.out.printf("%d, %.15f \n ", (i +1) , c);


            if (Math.signum(funcA) == Math.signum(funcC)) {
                a = c;
            } else {
                b = c;
            }
        }

       /* while (true) {
            c = (a + b) / 2;

            if (Math.abs(c) < 0.0000003721420) {
                System.out.println("opa");
                break;
            }

            System.out.println(c);

            if (Math.signum(functionQuest5(c)) == Math.signum(functionQuest5(a)) ) {
                a = c;
            } else {
                b = c;
            }
        }

        System.out.println(c);*/
    }

    public static Double value() {
        return (3.72142 * Math.pow(10, -11));
    }
}
