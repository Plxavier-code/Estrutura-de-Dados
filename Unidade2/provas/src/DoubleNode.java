public class DoubleNode <T> {
    // Variaveis
    private DoubleNode<T> previous;
    private T data;
    private DoubleNode<T> next;    
    // Getters 
    public T GetDate(){
        return data;
    }
    public DoubleNode<T> GetPrevious(){
        return previous; 
    }
    public DoubleNode<T> GetNext(){
        return next;
    }
    public void setDate(T data){
        this.data=data;
    }
    public void setPrevious(DoubleNode<T>  previous){
        this.previous=previous;
    }
      public void setNext(DoubleNode<T>  next){
        this.next=next;
    }
     
}