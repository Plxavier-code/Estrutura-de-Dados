
import java.util.NoSuchElementException;

public class LinkedStack<T> implements empilhavel<T>{
    private DoubleNode<T> top;
    private int amount;
    private int capacity;

    public LinkedStack(int capacity) {
        this.top = null;
        this.amount = 0;
        this.capacity = capacity;
    }

    @Override
    public boolean is_full() {
        return amount == capacity;
    }

    @Override
    public boolean is_empty() {
        return amount == 0;
    }

    @Override
    public String print() {
      String result="";
      DoubleNode<T> Current=top;
      for(int i=0;i<amount;i++){
        result+=Current.getData();
        if(i<amount-1){
          result+=" , ";
        }
        Current=Current.getPrevious();
      }
      return result;
    }

    @Override
    public T peek() {
        if (is_empty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return top.getData();
    }

    @Override
    public void push(T dado) {
        if (is_full()) {
            throw new NoSuchElementException("Stack is full");
        }
        DoubleNode<T> newNode = new DoubleNode<>(dado);
        if (is_empty()) {
            top = newNode;
        } else {
            newNode.setPrevious(top);
            top.setNext(newNode);
            top = newNode;
        }
        amount++;
    }

    @Override
    public T pop() {
        if (is_empty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        T data = top.getData();
        top = top.getPrevious();
        amount--;
        if (!is_empty()) {
            top.setNext(null);
        }
        
        return data;
    }
    
}
