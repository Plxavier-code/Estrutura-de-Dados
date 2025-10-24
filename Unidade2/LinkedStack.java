public class LinkedStack<T> implements empilhavel<T> {
    private DoubleNode<T> top;
    private int size;
    private int capacity;

    public LinkedStack(int capacity) {
        this.top = null;
        this.size = 0;
        this.capacity = capacity;
    }

    @Override
    public boolean is_full() {
        return size == capacity;
    }

    @Override
    public boolean is_empty() {
        return size == 0;
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        DoubleNode<T> current = top;
        while (current != null) {
            sb.append(current.getData()).append(" ");
            current = current.getNext();
        }
        return sb.toString().trim();
    }

    @Override
    public T peek() {
        if (is_empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.getData();
    }

    @Override
    public void push(T dado) {
        if (is_full()) {
            throw new IllegalStateException("Stack is full");
        }
        DoubleNode<T> newNode = new DoubleNode<>(dado);
        if (is_empty()) {
            top = newNode;
        } else {
            newNode.setNext(top);
            top.setPrevious(newNode);
            top = newNode;
        }
        size++;
    }

    @Override
    public T pop() {
        if (is_empty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.getData();
        top = top.getNext();
        if (top != null) {
            top.setPrevious(null);
        }
        size--;
        return data;
    }
    
}
