public class DoubleNode <T> {
    private T data;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;
    // construtor 
    public DoubleNode(T data){
        this.data=data;
        this.next=null;
        this.previous=null;
    } 
    // getters e setters
    public T getData(){
        return data;

    }
    public DoubleNode getNext(){
        return next;
    }
    public DoubleNode getprevious(){
        return previous;
    }
    public void setData(T data){
        this.data=data;
    }
    public void setNext(DoubleNode next){
        this.next=next;
    }
    public void setprevious(DoubleNode previous){
        this.previous=previous;
    }
}
