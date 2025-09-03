/*Faça um programa em Java que peça a idade e a altura de 5 pessoas, armazene cada informação no seu respectivo vetor. Imprima a idade
 e a altura na ordem inversa a ordem lida.*/
 //Biblioteca
 import java.util.Scanner;
public class Quest8 {
    public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
     // Variaveis
    int[] idade=new int[5];
    double[] altura=new double[5];
    //ler idade e altura 
    for(int i=0; i<5; i++){
        System.out.println("Insira a idadeda pessoa "+(i+1)+": ");
        idade[i]=sc.nextInt();
        System.out.println("Insira sua altura da pessoa "+(i+1)+": ");
        altura[i]=sc.nextDouble();
    }   
      // Impressão dos valores
      for (int i = 4; i>=0; i--) {
        System.out.println("\n"+(i+1)+"°"+"pessoa: ");
        System.out.println("Idade: "+idade[i]+"\nAltura: "+altura[i]);
          
      }
    }
}
