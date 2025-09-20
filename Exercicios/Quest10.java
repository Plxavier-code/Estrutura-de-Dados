// Faça um programa em Java que leia dois vetores com 10 elementos cada. Gere um terceiro vetor de 20 elementos
//Biblioteca
import java.util.Scanner;
public class Quest10{
    public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    Object[] vetor1=new Object[10];
    Object[] vetor2=new Object[10];
    Object[] vetor3=new Object[20];
    int aux=0;
    int cont=0;
    // ler vetores
     for (int i = 0; i < 20; i++) {
        System.out.println("insira o "+(i+1)+"º elemento: ");
        if(i<10){
        vetor1[i]=sc.next();
        }
        else{
            vetor2[(i%10)]=sc.next();
        }
    }
    for (int i = 0; i < 20; i++) {
        if(i%2==0){
            vetor3[i]=vetor1[aux];
            aux++;
        }
        else{
           vetor3[i]=vetor2[cont];
           cont++;
        }
        
    }
   System.out.print("{");
for (int i = 0; i < vetor3.length; i++) {
    if (i < vetor3.length - 1) {
        System.out.print(vetor3[i] + ", ");
    } else {
        System.out.print(vetor3[i]);
    }
}
System.out.println("}");

}
}