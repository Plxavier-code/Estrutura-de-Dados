//Bibliotecas
 import java.util.Scanner;
// Faça um programa em Java que leia um vetor de 5 números inteiros, mostre a soma, a multiplicação e os números.
public class Quest7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numeros = new int[5];   
        int soma = 0;
        int multiplicacao = 1;

        // leitura de números
        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o número " + (i + 1) + ": ");
            numeros[i] = sc.nextInt();

            // acumula soma e multiplicação
            soma += numeros[i];
            multiplicacao *= numeros[i];
        }

        // mostrar os números
        System.out.print("\nNúmeros digitados: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }

        // mostrar resultados
        System.out.println("\nSoma: " + soma);
        System.out.println("Multiplicação: " + multiplicacao);

        
    }
}

    

