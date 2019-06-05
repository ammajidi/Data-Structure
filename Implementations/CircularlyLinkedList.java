public class CircularlyLinkedList<E> {
    static  class Node<E> {
        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        private E element;
        private Node<E> next;

    }

    private Node<E> tail = null;
    private int size = 0;

    public CircularlyLinkedList() {
    }

    public int size(){
        if (size==0)
            return 0;
        Node<E> t = tail;
        int size=1;
        while(tail.getNext()!=t){
            tail=tail.getNext();
            size++;

        }
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty())
            return null;

        return tail.getNext().getElement();
    }

    public Node getTail() {
        return tail;
    }

    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void rotate() {
        if (tail != null)
            tail = tail.getNext();
    }

    public void addFirst(E e) { // adds element e to the front of the list
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail); // link to itself circularly
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }

    public void addLast(E e) { // adds element e to the end of the list
        addFirst(e);
        tail = tail.getNext(); // now new element becomes the tail
    }

    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) return null; // nothing to remove
        Node<E> head = tail.getNext();
        if (head == tail) tail = null; // must be the only node left
        else tail.setNext(head.getNext()); // removes ”head” from the list
        size--;
        return head.getElement();
    }


    public boolean equals(CircularlyLinkedList<E> other) {
        if (other.size!=this.size)
            return false;
        Node tail1 = this.tail;
        Node tail2 = other.tail;
        while (tail1.next != this.tail && tail2.next != other.tail) {
            if (tail1.element == tail2.element) {
                tail1 = tail1.next;
                tail2 = tail2.next;
            } else return false;
        }
        if (tail1.next == tail && tail2.next == other.tail)
            return true;
        else
            return false;

    }
}