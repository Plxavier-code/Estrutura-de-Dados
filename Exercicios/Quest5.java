//Bibliotecas
import java.util.ArrayList;
import java.util.Scanner;
/*  Faça um programa em Java que leia 20 números inteiros e armazene-os num vetor. Armazene os números pares no vetor PAR e os números
 IMPARES no vetor impar. Imprima os três vetores.*/
public class Quest5 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
// variaveis
int num[]= new  int[20];
ArrayList<Integer> par= new ArrayList<>();
ArrayList<Integer> impar= new ArrayList<>();
//Receber numeros 
for (int i = 0; i <= num.length-1; i++) {
    System.out.println("Insira o um numero: " );
    num[i]=sc.nextInt();
    
}
// separar pares e impares 
for(int i = 0; i <=num.length-1; i++){
    if(num[i]%2==0){
        par.add(num[i]);
    }
    else{
        impar.add(num[i]);
    }

}
// Imprimir vetores 
       for (int i = 0; i <= num.length-1; i++) {
    System.out.println("numeros : "+ num[i] );
    }
    
    System.out.println("Números pares: " + par);
    System.out.println("Números ímpares: " + impar);
    
}

}
