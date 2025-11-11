public interface listavel <T> {
      /*está cheio*/
     boolean is_full();
    
    /*esta vazio */ 
    boolean is_empty();
   
    /*imprimir  */ 
    String print();
   
    //metodos principais:
    /*Incerir na ultima posição da lista: */ 
    void append(T Dado);
    /*Incerir em posição : */ 
    void incert(int index, T date );
    /*Deletar algum dado de acordo ao index */ 
    T delete(int index, T date );
    /*Selecionar todos os dados da lista  */ 
    T selectAll();
    /*Selecionar um dado de acordo a posição*/ 
    T select(int Index);
    /*Atualizar um dado de acordo a posição*/ 
    void update(T date);

}
