public interface empilhavel <T> {
     /*está cheio*/
     boolean is_full();
    
    /*esta vazio */ 
    boolean is_empty();
   
    /*imprimir  */ 
    String print();
   
    //metodos principais:

    /*Espiar  */  
    T peek();
   
    /*Empilhar  */ 
    void push(T dado);
   
    /*Desempilhar */
    T pop();
    /*Atualizar */
    void update(T data);

   
}
    

