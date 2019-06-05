import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EulerTour<E> {
    LinkedBinaryTree<E> tree=new LinkedBinaryTree<>();
    public void elurTour(Position<E> p,List<Position<E>> snapshot){
        snapshot.add(p);
        if (tree.left(p) != null)
            elurTour(tree.left(p), snapshot);
        if (tree.right(p) != null)
            elurTour(tree.right(p), snapshot);
        if (!tree.isRoot(p))
            snapshot.add(tree.parent(p));
    }
    public void elur() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!tree.isEmpty())
            elurTour(tree.root(), snapshot); // fill the snapshot recursively
        for(Position<E> i:snapshot)
            System.out.print(i.getElement());
    }
    public static void main(String[] args) {
       EulerTour<Integer> e=new EulerTour<>();
        e.tree.addRoot(0);
        e.tree.addLeft(e.tree.root,1);
        e.tree.addRight(e.tree.root,2);
        LinkedBinaryTree<Integer>t1=new LinkedBinaryTree<>();
        t1.addRoot(3);
        t1.addLeft(t1.root,7);
        t1.addRight(t1.root,8);
        LinkedBinaryTree<Integer>t2=new LinkedBinaryTree<>();
        t2.addRoot(4);
        t2.addLeft(t2.root,9);
        t2.addRight(t2.root,10);
        e.tree.attach(e.tree.root.getLeft(),t1,t2);
//        LinkedBinaryTree<Integer>t3=new LinkedBinaryTree<>();
//        t3.addRoot(5);
//        t3.addLeft(t3.root,11);
//        t3.addRight(t3.root,12);
//        LinkedBinaryTree<Integer>t4=new LinkedBinaryTree<>();
//        t4.addRoot(6);
//        t4.addLeft(t4.root,13);
//        t4.addRight(t4.root,14);
//        e.tree.attach(e.tree.root.getRight(),t3,t4);

        e.elur();


    }

}
