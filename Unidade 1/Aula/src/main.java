package Aula.src;
public class main{
    public static void main(String[] args) {
        Pilha pilha=new Pilha(8);
        System.out.println("A Pilha está vazia?"+pilha.is_empty());
        pilha.push("Oi");
        pilha.push("tudo");
        pilha.push("bem,");
        pilha.push("como");
        pilha.push("vai");
        pilha.push("vc");
        pilha.push("hoje ");
        pilha.push("?");
        System.out.println("Conteúdo da pilha: " + pilha.print());
        System.out.println("Topo da pilha: " + pilha.peek());
        pilha.push("erro");
        System.out.println("Elemento removido: " + pilha.pop());
        System.out.println("Elemento removido: " + pilha.pop());
        
    }
}
