import java.util.Scanner;
public class Quest1{
    public static void main(String[] args) {
        Scanner sc= new Scanner (System.in);
        int [] a= new int [5];
     for(int cont=0; cont< a.length; cont++){
     System.out.println("Insira um numero:");
     a[cont]=sc.nextInt();
    }
    for(int cont=0; cont< a.length; cont++){
     System.out.print(+ a[cont]);
    }
}
} 
