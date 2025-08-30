//Biblioteca
import java.util.Scanner;
// Faça um programa em Java que leia 4 notas, mostre as notas e a média na tela.
public class Quest3 {
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
//Receber valores 
    // criar array
    double[] notas= new double[4];
    //Estrutura de repetição
    for(int i=0; i<=notas.length-1; i++){
        System.out.println("Insira a nota"+(i+1) +":");
        notas[i]=sc.nextDouble();
    }

// calcular média
   // varialvel média
   double media=0;
   // calculo da media 
   media= (notas[0]+notas[1]+notas[2]+notas[3])/4;

// printar as notas e a média
   //printar notas 
    for(int i=0; i<=notas.length-1; i++){
        System.out.print("nota"+(i+1)+":"+notas[i]+"  ");
        
    }  
    // printar media
    System.out.println("media: "+media);
}   
}
