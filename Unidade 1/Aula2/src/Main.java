public class Main {
    public static void main (String[] args) {
      Fila fila=new Fila(5);
      fila.emqueue("Pedro");
      fila.emqueue("Lucas");  
      fila.emqueue("Paulo");
      System.out.println("Frente da fila: " + fila.front());
        System.out.println("Elementos da fila 1: " + fila.print());

        System.out.println("desemfileirando a fila 1: " + fila.dequeue());
        fila.emqueue("João");
      fila.emqueue("Judas");  
      fila.emqueue("Tomé");
        System.out.println("Elementos da fila 1: " + fila.print());

        
}

}
    

