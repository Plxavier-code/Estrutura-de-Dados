//Bibliotecas
import java.util.Scanner;

/* 
6. Faça um programa em Java que peça as quatro notas de 10 alunos, calcule e armazene num vetor a média de cada aluno, 
imprima o número de alunos com média maior ou igual a 7.0.
*/
public class Quest6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Vetor para armazenar médias de 10 alunos
        double[] medias = new double[10];
        int aprovados = 0;

        // Para cada aluno
        for (int i = 0; i < medias.length; i++) {
            double soma = 0;

            // Lê 4 notas
            for (int cont = 0; cont < 4; cont++) {
                System.out.print("Insira a " + (cont + 1) + "ª nota do aluno " + (i + 1) + ": ");
                double nota = sc.nextDouble();
                soma += nota;
            }

            // Calcula média
            medias[i] = soma / 4.0;

            // Conta se o aluno foi aprovado
            if (medias[i] >= 7.0) {
                aprovados++;
            }
        }

        // Mostra todas as médias
        System.out.println("\nMédias dos alunos:");
        for (int i = 0; i < medias.length; i++) {
           System.out.println("Aluno " + (i + 1) + " → Média: " + medias[i]);
        }

        // Mostra total de aprovados
        System.out.println("\nNúmero de alunos com média maior ou igual a 7.0: " + aprovados);

    
    }
}