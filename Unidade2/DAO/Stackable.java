public interface Stackable<T> {
    void push(T data);      //C
    T peek();               //R
    void update(T newData); //U
    T pop();                //D

    boolean isEmpty();
    boolean isFull();
    String toString();
}