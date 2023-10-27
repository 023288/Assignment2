
public interface Queue<T> {
    
    void enqueue(T item);
    T dequeue();
    boolean empty();
    T peek();
    

}
