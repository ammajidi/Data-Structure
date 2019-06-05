public class CDLL {
    private static class Node {
        private Integer element; // reference to the element stored at this node
        private Node prev; // reference to the previous node in the list
        private Node next; // reference to the subsequent node in the list
        public Node(Integer e, Node p, Node n) {
            element = e;
            prev = p;
            next = n;
        }
        public Integer getElement() { return element; }
        public Node getPrev() { return prev; }
        public Node getNext() { return next; }
        public void setPrev(Node p) { prev = p; }
        public void setNext(Node n) { next = n; }
    }

    private int size;
    private Node tail=null;
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(Integer e){
        Node newest=new Node(e,null,null);
        if (this.isEmpty()){
            tail=newest;
            tail.setNext(tail);
            tail.setPrev(tail);
            return;
        }
        else {
            int count=0;
            //to be continued

        }
    }
    public Integer first() {
        if (isEmpty()) return null;
        return tail.getNext().getElement(); // first element is beyond header
    }
    public Integer last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }
    private Integer remove(Integer i) {
        Node node=new Node(null,null,null);
        int index=this.serarch(i);
        if (index!=0){

            node=tail.next;
            for (int j=0;j<=index;j++){
                node=node.next;
            }
            Node predecessor = node.getPrev();
            Node successor = node.getNext();
            predecessor.setNext(successor);
            successor.setPrev(predecessor);
            size--;
        }

        return node.getElement();
    }
    public void reverse(){

    }

    public CDLL add(CDLL c){
        if (this.isEmpty())
            return c;
        if (c.isEmpty())
            return this;
        else {
            for (int i=0;i<c.size;i++){
                this.add(c.tail.element);
                c.tail=tail;
            }
// bazam to be continued
        }
        return null;
    }
    public int serarch(Integer e){
        int count=size;
        int index=0;
        Node temp =new Node(null,null,null);
        temp=tail.next;

        while (count!=0){
            if (temp.element==e){
                index=size-count;
            }
            temp=temp.next;
        }
        if (index==0 &&!(tail.next.element==e) ){
            System.out.println("is not in it");
            return -1;}
        return index;
    }

    public String toString() {
        String s = "Contents:\n";

        Node current = tail.getNext();
        while (current != null) {
            s += current.getElement() + "\n";
            current = current.getNext();

        }

        return s;
    }
}
