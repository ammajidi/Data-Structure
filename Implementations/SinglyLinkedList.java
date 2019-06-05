
public class SinglyLinkedList <E>{
    static class Node<E>{
        public Node(E element,Node<E> next) {
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
    private Node<E> head = null;
    private Node<E> tail = null;
    private static int size=0;
    public Node<E> getHead() {
        return head;
    }
    public void setHead(Node<E> head) {
        this.head = head;
    }
    public Node<E> getTail() {
        return tail;
    }
    public void setTail(Node<E> tail) {
        this.tail = tail;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        if(size==0)
            return true;
        else
            return false;
    }
    public Node<E> last(){
        if(isEmpty())
            return null;
        else
            return tail;
    }
    public Node<E> first(){
        if(isEmpty())
            return null;
        else
            return head;
    }
    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (isEmpty())
            tail = head; // special case: new node becomes tail also
        size++;
    }
    public void addLast(E e) { // adds element e to the end of the list
         Node<E> newest = new Node<>(e, null); // node will eventually be the tail
         if (isEmpty())
             head = newest; // special case: previously empty list
         else
         tail.setNext(newest); // new node after existing tail
         tail = newest; // new node becomes the tail
         size++;
         }
    public E removeFirst(){
        if (isEmpty()){
            return null;
        }
        E answer = head.getElement();
        head=head.next;
        size--;
        return answer;
    }
    public void reverseList() {
        Node<E> curr = head;
        Node<E> pre = null;
        Node<E> incoming = null;

        while(curr != null) {
            incoming = curr.next;

            curr.next = pre;
            pre = curr;

            curr = incoming;
        }
        head = pre;
    }
    public void remove(int index)throws IndexOutOfBoundsException{
        if(index>size-1 || index<0){
            throw new IndexOutOfBoundsException("please choose a valid index");
        }
        Node temp=new Node<>(null,null);
        Node next=new Node<>(null,null);
        temp=head;
        if (index==0){
            removeFirst();
            return;
        }
        while (index>1){
            temp=temp.next;
            index--;
        }
        next=temp.next.next;
        temp.setNext(next);
        size--;
     }
    public void add(int index,E element) throws IndexOutOfBoundsException{
         if(index>size || index<0){
             throw new IndexOutOfBoundsException("please choose a valid index");
         }
         if (index==0){
             addFirst(element);
             return;
         }
         if (index==size){
             addLast(element);
             return;
         }

         Node temp=new Node<>(null,null);
         Node next=new Node<>(null,null);
         Node newest;
         temp=head;
         while (index-1>0){
            temp=temp.next;
            index--;
         }
         next=temp.next;
         newest= new Node<>(element,next);
         temp.next=newest;
         size++;
     }
}
