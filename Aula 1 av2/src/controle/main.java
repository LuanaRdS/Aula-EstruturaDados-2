package controle;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int N = 10;
        int[] codigos = new int[N];
        String[] nomes = new String[N];
        double[] valores = new double[N];

        System.out.println("Digite os dados dos 10 produtos:");

        for (int i = 0; i < N; i++) {
            System.out.println("Produto " + (i + 1));
            System.out.print("Código: ");
            codigos[i] = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            System.out.print("Nome: ");
            nomes[i] = scanner.nextLine();

            System.out.print("Valor: ");
            valores[i] = scanner.nextDouble();
            scanner.nextLine(); // consumir quebra de linha
        }

        // Ordenação por código
        Integer[] indicesPorCodigo = new Integer[N];
        for (int i = 0; i < N; i++) {
            indicesPorCodigo[i] = i;
        }

        Arrays.sort(indicesPorCodigo, Comparator.comparingInt(i -> codigos[i]));

        System.out.println("\nProdutos ordenados por CÓDIGO:");
        for (int i : indicesPorCodigo) {
            System.out.printf("Código: %d | Nome: %s | Valor: %.2f\n", codigos[i], nomes[i], valores[i]);
        }

        // Ordenação por valor
        Integer[] indicesPorValor = new Integer[N];
        for (int i = 0; i < N; i++) {
            indicesPorValor[i] = i;
        }

        Arrays.sort(indicesPorValor, Comparator.comparingDouble(i -> valores[i]));

        System.out.println("\nProdutos ordenados por VALOR (crescente):");
        for (int i : indicesPorValor) {
            System.out.printf("Código: %d | Nome: %s | Valor: %.2f\n", codigos[i], nomes[i], valores[i]);
        }

        scanner.close();
    }
}
