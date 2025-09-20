//Bibliotecas 
import java.util.ArrayList;
import java.util.Scanner;
//Faça um programa em Java que leia um vetor de 10 caracteres, e diga quantas consoantes foram lidas. Imprima as consoantes.
public class Quest4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] carac = new char[10];
        ArrayList<Character> cons = new ArrayList<>();
        int qtdCons = 0;

        System.out.println("insira 10 caracteres:");
        for (int i = 0; i < carac.length; i++) {
         System.out.println("insira o "+(i+1)+"º caractere");
         carac[i]=sc.next().toLowerCase().charAt(0);
        if(carac[i] != 'a' && carac[i] != 'e' && carac[i] != 'i' && carac[i] != 'o' && carac[i] != 'u'){
         cons.add(carac[i]);
         qtdCons++;
         }

        }
        System.out.println("[");
         for (int i = 0; i < cons.size(); i++) {
            System.out.print(cons.get(i));
            if (i < cons.size() - 1) {
                System.out.print(", "); 
        }
            }
            System.out.println("]"); 
     }
}        