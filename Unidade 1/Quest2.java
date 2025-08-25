/*2. Faça um programa em Java que leia um vetor de 10 números reais e mostre-os na ordem inversa. */
import java.util.Scanner;
public class Quest2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        double[] a= new double[10];
        int cont=0;
        for ( cont=0; cont< a.length; cont++){
            System.out.println( "Insira um numero: " );
            a[cont]=sc.nextDouble();
        }
        for(cont=a.length-1 ; cont!=0;cont--){
            System.out.println(a[cont]);
            

        }

    }
    
}
