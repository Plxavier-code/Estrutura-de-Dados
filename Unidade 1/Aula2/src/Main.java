public class Main {
    public static void main(String[] args) {
        // Criar fila com capacidade 5
        Fila fila = new Fila(5);

        
         fila.is_empt();
         fila.is_full();
         fila.print();

        fila.enqueue("A");
        fila.enqueue("B");
        fila.enqueue("C");
        fila.enqueue("D");
        fila.enqueue("E"); // fila cheia
        System.out.println("Fila após enfileirar A, B, C, D, E: " + fila.print());
        System.out.println("Fila está cheia? " + fila.is_full());
        fila.enqueue("F");

        fila.front();
        fila.dequeue();
        fila.dequeue();
        fila.print();
        fila.front();
        fila.enqueue("X");
        fila.enqueue("Y");
        fila.print();

    }
}
