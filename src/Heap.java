

import java.util.Comparator;

public class Heap <T> {
    

    private T[] arr;
    private int length;
    private int capacity;
    private Comparator<T> comparator;
    
    
    public Heap(Comparator<T> c)
    {
        arr = null;
        length = 0;
        capacity = 0;
        comparator = c;
    }
    
    public void setComparator(Comparator<T> c)
    {
        comparator = c;
    }
    
    public boolean empty()
    {
        return length <= 0;
    }
    
    public int size() {
        return length;
    }
    
    public T peek()
    {
        return arr[0];
    }

    public void insert(T item) {
    
        if (length == capacity)
        {
            grow_array();
        }
        arr[length++] = item;

        int child = length - 1;
        while (child > 0 && comparator.compare(arr[child], arr[parent(child)]) < 0) {
            swap(arr, parent(child), child);
            child = parent(child);
        }
    }
    
    public T remove() {
        
        T item = arr[0];
        arr[0] = arr[--length];
        shiftDown(0);

        return item;
    }

    private void grow_array() {

        if (0 == capacity) {
            capacity = 1;
        }
        else {
            capacity = capacity * 2;
        }
        @SuppressWarnings("unchecked")
        T[] new_arr = (T[]) new Object[capacity];
        for (int i = 0; i < length; i++) {
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }
    
    
    private void shiftDown(int parent) {
        
        while (true) {
            
            int child = left(parent);

            if (child >= length)
            {
                break;
            }
            if (child + 1 < length && comparator.compare(arr[child + 1], arr[child]) < 0)
            {
                child = child + 1;
            }
            
            if (comparator.compare(arr[child], arr[parent]) < 0)
            {
                swap(arr, parent, child);
                parent = child;
            }
            else
            {
                break;
            }
        }
        
    }

    private int parent(int child) {
        return (child - 1) / 2;
    }
    
    private int left(int parent) {
        return parent * 2 + 1;
    }

    private void swap(T[] list, int i, int j)
    {
        T temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }
}
