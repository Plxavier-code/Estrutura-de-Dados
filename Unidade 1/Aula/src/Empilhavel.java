package Aula.src;
public interface Empilhavel{
    //metodos auxiliares:
    
    /*está cheio*/ boolean is_full();
    /*esta vazio */ boolean is_empty();
    /*imprimir  */ String print();
    //metodos principais:

    /*Espiar  */ Object peek(); 
    /*Empilhar  */ void push(Object dado);
    /*Desempilhar */Object pop();
}

    


