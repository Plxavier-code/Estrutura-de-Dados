// Faça um programa em Java que leia um vetor A com 10 números inteiros, calcule e mostre a soma dos quadrados dos elementos do vetor.
//Bibliotecas
import java.util.Scanner;
public class Quest9 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Variaveis
    int[] num = new int[10];
    int soma = 0;

    // leitura dos valores
    for (int i = 0; i < num.length; i++) {
        System.out.print("Digite o " + (i+1) + "º número: ");
        num[i] = sc.nextInt();
    }

    // cálculo da soma dos quadrados
    for (int i = 0; i < num.length; i++) {
        soma += num[i] * num[i]; 
    }

    // Impressão do resultado
    System.out.println("A soma dos quadrados dos elementos do vetor é: " + soma);
    }       
    }
   


