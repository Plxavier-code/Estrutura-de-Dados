public interface  Listavel {
    void append(Object dado);
    void insert(int logicla_index, Object dado);
    Object select(int index);
    Object[] sectall();
    void update(int index,Object dado);
    Object delete(int index);
    //Metodos auxiliares 
    boolean is_full();
    boolean is_empty();
    String print();    
}
