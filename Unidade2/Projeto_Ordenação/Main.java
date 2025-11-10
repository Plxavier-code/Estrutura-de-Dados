import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] tamanhos = {10, 100, 1000};
        int repeticoes = 10;
        Random random = new Random();

        for (int n : tamanhos) {
            System.out.println("==== Teste com " + n + " elementos ====");
            long somaTempos = 0;

            for (int r = 0; r < repeticoes; r++) {
                int[] array = new int[n];
                for (int i = 0; i < n; i++) {
                    array[i] = random.nextInt(10000);
                }

                long inicio = System.nanoTime();
                ParaleloBitonicSort.sort(array);
                long fim = System.nanoTime();

                somaTempos += (fim - inicio);
            }

            double mediaTempoMs = (somaTempos / (double) repeticoes) / 1_000_000.0;
            System.out.printf("Tempo médio após %d execuções: %.3f ms%n", repeticoes, mediaTempoMs);
            System.out.println("-----------------------------------------------\n");
        }
    }
}
