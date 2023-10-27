

public class LinkedQueue <T> implements Queue<T> 
{
    private Link head;
    private Link tail;
    private int length;

    public LinkedQueue()
    {
        head = tail = new Link();
        length = 0;
    }

    @Override
    public void enqueue(T elem)
    {
        tail.setNext(new Link(elem, null));
        tail = tail.next();
        length++;
    }

    @Override
    public T dequeue()
    {
        Link removeLink = null;
        
        Link tmp = head;
        removeLink = tmp.next();
        tmp.setNext(removeLink.next());
        if (tail == removeLink) {
            tail = head;
        }
        length--;
        
        return removeLink.element();
    }

    @Override
    public boolean empty() {
        return length <= 0;
    }
    
    @Override
    public T peek() {
        return head.next().element();
    }

    private class Link {

        /*----------------------------------------------------- */
        /*  Private Data Members -- Link                        */
        /*----------------------------------------------------- */

        private T element;
        private Link next;

        /*----------------------------------------------------- */
        /*  Constructors -- Link                                */
        /*----------------------------------------------------- */

        Link(T elem, Link nextelem) {
            element = elem;
            next = nextelem;
        }
        
        Link() { }

        /*----------------------------------------------------- */
        /*  Access Methods -- Link                              */
        /*----------------------------------------------------- */

        Link next() {
            return next;
        }

        T element() {
            return element;
        }

        void setNext(Link nextelem) {
            next = nextelem;
        }

    }

}