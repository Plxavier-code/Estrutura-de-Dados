import java.util.NoSuchElementException;
public class LinkedStack <T> implements empilhavel <T> {
    //Variaveis 
    private DoubleNode<T> top;
    private int amount;
    private int capacity;
    //Construtor
    public LinkedStack(){
        this(10);
    }
    public LinkedStack(int capacity){
        this.top=null;
        this.amount=0;
        this.capacity=capacity;

    }
    //Metodos auxiliares
    @Override
    public boolean is_full() {
        return amount == capacity;
    }

    @Override
    public boolean is_empty() {
        return amount == 0;
    }
    @Override
    public String print(){
        String format="";
        DoubleNode<T>current=top;
        for(int i=0;i<amount;i++){
            format+=current.GetDate();
            if(i<amount-1){
                format+=",";
            }
            current=current.GetPrevious();

        }
        return format;

    }
    //Metodos principais 
    @Override
    public T peek(){
        if(is_empty()){
            throw new NoSuchElementException("Pilha está vazia");
        } 
        return top.GetDate();
    }
    @Override
    public void push(T date){
        if(is_full()){
            throw new NoSuchElementException("Pilha está cheia");
        } 
        DoubleNode<T>aux= new DoubleNode<T>();
        aux.setDate(date); 
        aux.setPrevious(top);
        if(!is_empty()){
        top.setNext(aux);
     }
     top=aux;
     amount++;
    }
    @Override
    public T pop(){
         if(is_empty()){
            throw new NoSuchElementException("Pilha está vazia");
        } 
        T pointer=top.GetDate();
        top=top.GetPrevious();
        amount--;
        if(!is_empty()){
            top.setNext(null);
        }
        return pointer;
    }
    @Override
    public void update(T data){
        if(is_empty()){
            throw new NoSuchElementException("Pilha está vazia");
        } 
        top.setDate(data);

    }
}
