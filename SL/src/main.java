import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class main {
     /* int tam;

        List<List<Double>> mat = new ArrayList<>();

        List<Double> list = new ArrayList<>();

        list.add(numero(5, 3));
        list.add(numero(7, 4));
        list.add(numero(8, 9));
        copy(mat, list, 0);
        list.removeAll(list);

        list.add(numero(7, 8));
        list.add(numero(-1, 5));
        list.add(numero(7, 8));
        copy(mat, list, 1);
        list.removeAll(list);

        list.add(numero(2, 3));
        list.add(numero(4, 9));
        list.add(numero(8, 3));
        copy(mat, list, 2);
        list.removeAll(list);

        list.add(numero(-2, 3));
        list.add(numero(3, 5));
        list.add(numero(3, 8));
        copy(mat, list, 3);
        list.removeAll(list);

        multiplicarLinha(mat, 3, numero(-3, 5));
        trocarLinhas(mat, 1, 2);
        somaLinhasMult(mat, 0,numero(8, 5), 3, 3);
        trocarLinhas(mat, 1, 3);

        multiplicarLinha(mat, 2, numero(7, 9));
        somaLinhasMult(mat, 2,numero(5, 1), 0, 0);
        printMatriz(mat);*/

    public static void copy(List<List<Double>> mat, List<Double> list, int pos) {
        List<Double> newList = new ArrayList<>();
        int i = 0;
        for (Double item : list) {
            newList.add(i, item);
            i++;
        }

        mat.add(pos, newList);
    }

    public static void jacobi(List<List<Double>> A, List<Double> B, List<Double> chute, int n) {
        List<Double> next = new ArrayList<>();
        Locale.setDefault(Locale.US);
        for (int k = 0; k < n; k++) {
            System.out.printf("%d ", k + 1);
            for (int i = 0; i < A.size(); i++) {
                Double bi = B.get(i);
                for (int j = 0; j < A.get(i).size(); j++) {
                    if (j != i) {
                        bi -= A.get(i).get(j) * chute.get(j);
                    }
                }
                bi /=A.get(i).get(i);
                System.out.printf("%.16f, ", bi);
                next.add(i, bi);
            }
            System.out.println("");

            for (int i = 0; i < A.size(); i++) {
                chute.add(i, next.get(i));
            }
        }
    }

    public static void main(String arg[]) {

        List<List<Double>> mat = new ArrayList<>();

        List<Double> list = new ArrayList<>();

        list.add(-8.0);
        list.add(-5.0);
        list.add(-7.0);
        list.add(-8.0);
        copy(mat, list, 0);
        list.removeAll(list);

        list.add(-7.0);
        list.add(-4.0);
        list.add(-2.0);
        list.add(6.0);
        copy(mat, list, 1);
        list.removeAll(list);

        list.add(-1.0);
        list.add(-1.0);
        list.add(-4.0);
        list.add(3.0);
        copy(mat, list, 2);
        list.removeAll(list);

        list.add(-2.0);
        list.add(3.0);
        list.add(-6.0);
        list.add(-6.0);
        copy(mat, list, 3);
        list.removeAll(list);

        somaLinhasMult(mat, 0, numero(-7,8), 1, 1);
        somaLinhasMult(mat, 0, numero(-1,8), 2, 2);
        somaLinhasMult(mat, 0, numero(-1,4), 3, 3);
        somaLinhasMult(mat, 1, numero(1,1), 2, 2);
        somaLinhasMult(mat, 1, numero(-34,3), 3, 3);
        somaLinhasMult(mat, 2, numero(51,1), 3, 3);







        printMatriz(mat);

        /*list.add(-2.49);
        list.add(2.55);
        list.add(2.15);
        list.add(8.62);
        list.add(4.97);
        copy(mat, list, 3);
        list.removeAll(list);

        List<Double> B = new ArrayList<>();
        B.add(4.1);
        B.add(4.92);
        B.add(4.26);
        B.add(-2.01);
*/

        /*List<Double> chute =  new ArrayList<>();

        chute.add(-0.7);
        chute.add(-2.36);
        chute.add(0.16);
        chute.add(2.89);

        seidel(mat,chute, 25);*/
    }


    public static void seidel(List<List<Double>> A, List<Double> chute, int n) {
        Locale.setDefault(Locale.US);

        int numColunas = A.get(0).size();

        for(int i=0; i<n; i++) {
            System.out.printf("%d ", i +1);
            for(int j=0; j< A.size(); j++) {
                Double bj = A.get(j).get((numColunas -1));
                Double soma =  0.0000000000000000;
                for(int k=0; k < numColunas - 1; k++) {
                    if(k != j) {
                        soma+= (A.get(j).get(k) * chute.get(k));
                    }
                }
                Double xj = (bj - soma)/ A.get(j).get(j);
                chute.set(j, xj);
                System.out.printf("%.16f, ", xj);
            }
            System.out.println("");
        }

    }

    public static void gauss(List<List<Double>> mat ) {

        for(int j =0; j< mat.get(0).size() - 2; j++) {
            for(int i=j; i <  mat.size(); i ++) {
                if(mat.get(i).get(j) != 0) {
                    for(int k = 0; k < mat.size(); k++) {
                        Double temp = mat.get(i).get(k);
                        mat.get(i).add(k, mat.get(j).get(k));
                        mat.get(j).add(k, temp);
                    }
                }
            }
        }
    }

    public static void multiplicarLinha(List<List<Double>> mat, int linha, Double number) {
        int i = 0;
        for (Double item : mat.get(linha)) {
            mat.get(linha).set(i, item * number);
            i++;
        }
    }

    public static Double numero(Integer primeiro, Integer segundo) {
        Double num1 = new Double(primeiro);
        Double num2 = new Double(segundo);

        return num1 / num2;
    }

    public static void printMatriz(List<List<Double>> mat) {
        for (List<Double> itemLinha : mat) {
            for (Double itemColuna : itemLinha) {
                System.out.printf("%.10f, ", itemColuna);
            }
            System.out.println("");
        }
    }

    public static void somaLinhasMult(List<List<Double>> mat, int linhaMult, Double number, int linhaSoma, int linhaDestino) {
        List<Double> mult = new ArrayList<>();

        for (Double item : mat.get(linhaMult)) {
            mult.add(item * number);
        }

        int i = 0;
        for (Double item : mat.get(linhaSoma)) {
            mat.get(linhaDestino).set(i, (mult.get(i) + item));
            i++;
        }
    }


    public static void diminuirLinhasMult(List<List<Double>> mat, int linhaMult, Double number, int linhaSoma, int linhaDestino) {
        List<Double> mult = new ArrayList<>();

        for (Double item : mat.get(linhaMult)) {
            mult.add(item * number);
        }

        int i = 0;
        for (Double item : mat.get(linhaSoma)) {
            mat.get(linhaDestino).set(i, ( item - mult.get(i) ));
            i++;
        }
    }

    public static void trocarLinhas(List<List<Double>> mat, int linha1, int linha2) {
        List<Double> aux = new ArrayList<>();
        for (Double item :
                mat.get(linha2)) {
            aux.add(item);
        }

        int i = 0;
        for (Double item : aux) {
            mat.get(linha2).set(i, mat.get(linha1).get(i));
            i++;
        }

        mat.set(linha1, aux);
    }
}
