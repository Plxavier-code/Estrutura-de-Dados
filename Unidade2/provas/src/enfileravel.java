public interface enfileravel <T> {
     /*está cheio*/
     boolean is_full();
    
    /*esta vazio */ 
    boolean is_empty();
   
    /*imprimir  */ 
    String print();
    //Metodos principais 
      /*Espiar  */  
    T peek();
    
    /*Empilhar  */ 
    void enqueue(T data);
    
    /*Desempilhar */
    T dequeue();
    /*Atualizar */
    void update(T data);

   
}
