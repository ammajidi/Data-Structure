import java.util.Iterator;

public class PositionalLinkedList<E> implements PositionalList<E>,Iterable<E>{

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
    public Iterable<Position<E>> positions(){
        return new PositionItrabale();
    }
    private static class Node<E> implements Position<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the subsequent node in the list
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
             prev = p;
             next = n;

             }

        public E getElement() throws IllegalStateException {
             if (next == null) // convention for defunct node
                 throw new IllegalStateException("Position no longer valid");
             return element;

             }

        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setElement(E e) {
            element = e;
        }
        public void setPrev(Node<E> p) {
            prev = p;
        }
        public void setNext(Node<E> n) {
            next = n;
        }


    }
    private int size=0;
    private Node header;
    private Node trailer;

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
        Node<E> node = (Node<E>) p;
        if (node.getNext() == null)
            throw new IllegalArgumentException("p is no longer in the list");
        return node;
    }

    private Position<E> position(Node<E> node)
    { if (node == header || node == trailer)
        return null;
        return node;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public Position first() {
        return position(header.getNext());
    }


    @Override
    public Position last() {
        return position(trailer.getPrev());
    }

    @Override
    public Position before(Position p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        return position(node.getPrev());
    }

    @Override
    public Position after(Position p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    @Override
    public Position addBefore(Position p, Object e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }
    public Position addAfter(Position p, E e) {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }
    private Position<E> addBetween(Object e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }
    @Override
    public Position<E> addFirst(Position e) {
        return addBetween(e,header,header.getNext());

    }

    @Override
    public Position addLast(Position p) {
        return addBetween(p, trailer.getPrev(), trailer);
    }

    @Override
    public E set(Position<E> p,E e)throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }
    @Override
    public E remove(Position p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size=size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setNext(null);
        node.setPrev(null);
        return answer;
         }
    private class PositionalIterator<E> implements Iterator<Position<E>>{
            private Position<E> crusor=first();
            private Position<E> recent=null;
            @Override
            public boolean hasNext() {
                return crusor!=null;
            }

            @Override
            public Position<E> next() {
                recent=crusor;
                crusor=after(crusor);
                return recent;
            }
            public void remove(){
                PositionalLinkedList.this.remove(recent);
            }
    }
    private class ElementIterator implements Iterator<E> {
            PositionalIterator<E> p = new PositionalIterator<>();

            @Override
            public boolean hasNext() {
                return p.hasNext();
            }

            @Override
            public E next() {
                return p.next().getElement();
            }

            @Override
            public void remove() {
                p.remove();
            }

            }
    private class PositionItrabale implements Iterable<Position<E>>{
                @Override
                public Iterator<Position<E>> iterator() {
                    return new PositionalIterator<>();
                }
            }
    public static void main(String[] args) {
        PositionalLinkedList<Integer> positionalLinkedList = new PositionalLinkedList<>();
        for (Position<Integer> s :positionalLinkedList.positions()) ;

    }

}


