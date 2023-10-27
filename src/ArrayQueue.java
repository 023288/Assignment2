
public class ArrayQueue<T>  implements Queue<T> {

    private T[] arr;
    private int length;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue() {

        arr = null;
        length = 0;
        capacity = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public void enqueue(T item) {
        if (capacity == length)
        {
            grow_array();
        }
        arr[tail] = item;
        tail = (tail + 1) % capacity;
        length++;
    }
    
    @Override
    public T dequeue() {
        T temp = arr[head];
        head = (head + 1) % capacity;
        --length;
        return temp;
    }
    
    @Override
    public boolean empty() {
        return length <= 0;
    }
    
    @Override
    public T peek() {
        return arr[0];
    }

    private void grow_array() {
        
        int oldCapacity = capacity;

        if (0 == capacity) {
            capacity = 1;
        }
        else {
            capacity = capacity * 2;
        }
        int cur = head;
        @SuppressWarnings("unchecked")
        T[] new_arr = (T[]) new Object[capacity];
        for (int i = 0; i < length; i++) {
            new_arr[i] = arr[cur];
            cur = (cur + 1) % oldCapacity;
        }
        arr = new_arr;
        head = 0;
        tail = head + length;
        
    }
}
