package Aula.src;
public interface Empilhavel{
    //metodos auxiliares:
    
    /*está cheio*/
     boolean is_full1();
      boolean is_full2();
    /*esta vazio */ 
    boolean is_empty1();
    boolean is_empty2();
    /*imprimir  */ 
    String print1();
    String print2();
    //metodos principais:

    /*Espiar  */  
    Object peek1();
    Object peek2(); 
    /*Empilhar  */ 
    void push1(Object dado);
    void push2(Object dado);
    /*Desempilhar */
    Object pop1();
    Object pop2();
}

    


