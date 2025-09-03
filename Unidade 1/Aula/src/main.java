package Aula.src;
public class main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(6); 
        pilha.push1("Pedro");
        pilha.push1("Lucas ");
        pilha.push1("Vinicius");
        System.out.println("Topo da Pilha 1: " + pilha.peek1());
        System.out.println("Elementos Pilha 1: " + pilha.print1());

        System.out.println("desempilhando Pilha 1: " + pilha.pop1());
        System.out.println("Elementos Pilha 1: " + pilha.print1());

        pilha.push2("Wesley");
        pilha.push2("Paulo");
        pilha.push2("Davi");
        System.out.println("Topo da Pilha 2: " + pilha.peek2());
        System.out.println("Elementos Pilha 2: " + pilha.print2());

        System.out.println("desempilhando  Pilha 2: " + pilha.pop2());
        System.out.println("Elementos Pilha 2: " + pilha.print2());
        pilha.push1("Matheus");
        pilha.push1("Ana");
        System.out.println("Elementos Pilha 1: " + pilha.print1());
        pilha.push1("Cassie"); 
    }
}