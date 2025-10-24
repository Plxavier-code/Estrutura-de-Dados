
public class DoubleNode <T>  {
    private T data;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;
     //construtor
    public DoubleNode(T data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
    //getters e setters
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
    
}
