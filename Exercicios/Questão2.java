/*  Implemente em Java um método “String decToBin(String data)” que retorne a 
representação Binária de números Decimais, utilizando a estrutura de dados do tipo Pilha 
Estática. Considere que todos os métodos da pilha estática estejam disponíveis para uso. 
Entrada 
Saída 
System.out.println(decToBin(“10”)); 
System.out.println(decToBin(“255”)); 
1010 
11111111 
System.out.println(decToBin(“35”)); 
100011 */
import java.util.Stack;
public class Questão2 {
     private Stack<String> pilha = new Stack<>();
     private int num;
     public void valordec(int numero ){
      num=numero;
      String bin=decToBin(“10”)
     }

}