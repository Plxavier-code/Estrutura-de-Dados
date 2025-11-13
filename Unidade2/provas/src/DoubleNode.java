public class DoubleNode<T> {
    // Variáveis de instância
    private DoubleNode<T> previous;
    private T data;
    private DoubleNode<T> next;

    // Construtores
    public DoubleNode() {
        this(null, null, null);
    }

    public DoubleNode(T data) {
        this(data, null, null);
    }

    public DoubleNode(T data, DoubleNode<T> previous, DoubleNode<T> next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    // Getters
    public T getData() {
        return data;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    // Setters
    public void setData(T data) {
        this.data = data;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
}
