import java.util.NoSuchElementException;

import Pilha.DoubleNode;
public class  LinkedQueue<T>implements enfileravel<T>{
    //Variaveis 
    private DoubleNode<T> head;
    private DoubleNode<T> tail;
    private int amount;
    private int capacity;
    //Construtores 
    public LinkedQueue(){
        this(10);
    }
    public LinkedQueue(int capacity){
        this.amount=0;
        this.head=null;
        this.tail=null;
        this.capacity=capacity;
    }
    //metodos auxiliares
    public boolean is_full(){
        return (amount==capacity );
    }
    public boolean is_empty(){
        return (amount==0 );
    }
    public String print(){
        String format="[";
        DoubleNode<T>current=head;
        for(int i=0;i<amount;i++){
            format+=current.GetDate();
            if(i!=amount-1){
                format+=",";
        }
        current=current.GetNext();
    }
    return format+"]";
}
    //metodos Principais 
    public T peek(){
        if(is_empty()){
            throw new NoSuchElementException("fila está vazia");
        }
        return head.GetDate();
    }
    public void enqueue(T data){
        if(is_full()){
            throw new NoSuchElementException("Fila está cheia");
        }
        DoubleNode<T> temp=new DoubleNode<>();
        temp.setDate(data);
        temp.setPrevious(tail);
        if (is_empty()) { 
        head = temp; 
        } else {
        tail.setNext(temp);
        }
        tail=temp;
        amount++;
    }
    public T dequeue(){
         if(is_empty()){
            throw new NoSuchElementException("fila está vazia");
        }
        T aux=tail.GetDate();
        tail=tail.GetPrevious();
        amount--;
        if(!is_empty()){
            tail.setNext(null);
        }
        return aux;
    }
    public void update(T data ){
         if(is_empty()){
            throw new NoSuchElementException("fila está vazia");
        }
        tail.setDate(data);
    }
}