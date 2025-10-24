import java.util.NoSuchElementException;

public class LinkedEnqueue <T> implements enfileravel <T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int amount;
    private int length;
    //construtor 
    public LinkedEnqueue(){
        this(10);
    }
    public LinkedEnqueue(int length){
        this.head=null;
        this.tail=null;
        this.amount=0;
        this.length= length;

    }
    //metodo auxiliares 
     /*está cheio*/
    public boolean is_full(){
        return amount==length;
    }
    /*esta vazio */ 
    public boolean is_empty(){
        return amount==0;
    }
    /*imprimir  */ 
    public String print(){
        String result="";
        DoubleNode<T>aux=head;
        for(int i=0;i<amount;i++){
            result+=aux.getData();
            if(i!=amount-1){
                result+=",";
            }
            aux=aux.getNext();
        }
        return "["+result+"]";
    }
    //metodos principais:
    public T peek(){
        if(is_empty()){
            throw new NoSuchElementException("fila Vazia");
        }
        DoubleNode<T>aux= head;
        return aux.getData();
    }
    public void enqueue(T data ){
        is_full();
        throw new NoSuchElementException("fila cheia");
        DoubleNode<T> tempNode= new DoubleNode<T>();

    }

    
}
