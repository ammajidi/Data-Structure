import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public  class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {
    @Override
    public Position<E> left(Position p) {
        Node<E> node = validate(p);
        return node.getLeft();
    }
    @Override
    public Position<E> right(Position p) {
        Node<E> node = validate(p);
        return node.getRight();
    }
    protected static class Node<E> implements Position<E> {
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public E getElement() { return element; }
        public Node<E> getParent() { return parent; }
        public Node<E> getLeft() { return left; }
        public Node<E> getRight() { return right; }

        public void setElement(E e) { element = e; }
        public void setParent(Node<E> parentNode) { parent = parentNode; }
        public void setLeft(Node<E> leftChild) { left = leftChild; }
        public void setRight(Node<E> rightChild) { right = rightChild; }
    }
    protected Node<E> createNode(E e, Node<E> parent, Node<E> left, Node<E> right) {
        return new Node<E>(e, parent, left, right);
    }
    protected Node<E> root = null; // root of the tree
    private int size = 0; // number of nodes in the tree
    public LinkedBinaryTree() { }
    protected static<E> Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node))
            throw new IllegalArgumentException("Not valid position type");
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getParent() == node) // our convention for defunct node
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
    public int size() {
        return size;
    }
    //---------------- nested ElementIterator class ----------------
    //∗ This class adapts the iteration produced by positions() to return elements. ∗/
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext() { return posIterator.hasNext(); }
        public E next() { return posIterator.next().getElement(); } // return element!
        public void remove() { posIterator.remove(); }
    }
    //∗∗ Returns an iterator of the elements stored in the tree. ∗/
    @Override
    public Iterator iterator() {
        return new ElementIterator();
    }
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
         if (left(p) != null)
             inorderSubtree(left(p), snapshot);
         snapshot.add(p);
         if (right(p) != null)
             inorderSubtree(right(p), snapshot);
         }
    public Iterable<Position<E>> inorder() {
         List<Position<E>> snapshot = new ArrayList<>();
         if (!isEmpty())
             inorderSubtree(root(), snapshot); // fill the snapshot recursively
         return snapshot;
    }
    @Override
    public Iterable<Position<E>> positions() {
        return inorder();
    }
    public Position<E> root() {
        return root;
    }
    @Override
    public Position<E> parent(Position p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getLeft() != null)
            throw new IllegalArgumentException("p already has a left child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> parent = validate(p);
        if (parent.getRight() != null)
            throw new IllegalArgumentException("p already has a right child");
        Node<E> child = createNode(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (isInternal(p)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if (!t1.isEmpty()) { // attach t1 as left subtree of node
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if (!t2.isEmpty()) { // attach t2 as right subtree of node
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        if (numChildren(p) == 2)
            throw new IllegalArgumentException("p has two children");
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight() );
        if (child != null)
            child.setParent(node.getParent()); // child’s grandparent becomes its parent
        if (node == root)
            root = child; // child becomes root
        else {
            Node<E> parent = node.getParent();
            if (node == parent.getLeft())
                parent.setLeft(child);
            else
                parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null); // help garbage collection
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); // our convention for defunct node
        return temp;
    }







////////////////////////////////////////////////////////////////////////////Here you are
    public static <E> void elurTour(Tree<Position<E>> t ,Position<E> p,String previsit,String postvisit){
        Node<E> node= validate(p);
        if (t.isInternal((Position)(p)))
            System.out.print(previsit);
        if (node.left!=null)
            elurTour(t,node.left,previsit,postvisit);
        System.out.print(p.getElement());
        if (node.right!=null)
            elurTour(t,node.right,previsit,postvisit);
        if (t.isInternal((Position)(p)))
            System.out.print(postvisit);
    }
    public static void main(String[] args) {
      LinkedBinaryTree<String>t=new LinkedBinaryTree<>();
        t.addRoot("-");
        t.addLeft(t.root,"/");
        t.addRight(t.root,"+");
        LinkedBinaryTree<String>t1=new LinkedBinaryTree<>();
        t1.addRoot("*");
        t1.addLeft(t1.root,"+");
        t1.addRight(t1.root,"3");
        LinkedBinaryTree<String>t2=new LinkedBinaryTree<>();
        t2.addRoot("+");
        t2.addLeft(t2.root,"-");
        t2.addRight(t2.root,"2");
        t.attach(t.root.left,t1,t2);
        LinkedBinaryTree<String>t3=new LinkedBinaryTree<>();
        t3.addRoot("*");
        t3.addLeft(t3.root,"3");
        t3.addRight(t3.root,"-");
        LinkedBinaryTree<String>t4=new LinkedBinaryTree<>();
        t4.addRoot("6");
        t.attach(t.root.right,t3,t4);
        LinkedBinaryTree<String>t5=new LinkedBinaryTree<>();
        LinkedBinaryTree<String>t6=new LinkedBinaryTree<>();
        t5.addRoot("3");
        t6.addRoot("1");
        t.attach(t.root.left.left.left,t5,t6);
        LinkedBinaryTree<String>t7=new LinkedBinaryTree<>();
        LinkedBinaryTree<String>t8=new LinkedBinaryTree<>();
        t7.addRoot("9");
        t8.addRoot("5");
        t.attach(t.root.left.right.left,t7,t8);
        LinkedBinaryTree<String>t9=new LinkedBinaryTree<>();
        LinkedBinaryTree<String>t10=new LinkedBinaryTree<>();
        t9.addRoot("7");
        t10.addRoot("4");
        t.attach(t.root.right.left.right,t9,t10);

        elurTour(t,t.root(),"(",")");

    }
}