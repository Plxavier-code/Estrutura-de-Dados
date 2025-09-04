
public interface Emfileravel {
// Metodos auxiliares   
 /*está cheio*/
     boolean is_full();
      
    /*esta vazio */ 
    boolean is_empt();
    
    /*imprimir  */ 
    String print();

    //metodos principais:
    // Frente da fila 
    Object front();
    //Emfilerar
    void emqueue(Object dado);
    //Desemfilerar
    Object dequeue();


  

    
}
