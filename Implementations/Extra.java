

public class Extra {
    /*/Describe an algorithm for concatenating two singly linked lists L and M, into a
single list L′ that contains all the nodes of L followed by all the nodes of M.

Describe in detail an algorithm for reversing a singly linked list L using only a
constant amount of additional space.
/*/

    public static SinglyLinkedList concatenate(SinglyLinkedList list1,SinglyLinkedList list2) {
        if (list1.isEmpty()) return list2;
        if (list2.isEmpty()) return list1;
        while (list2.size()!=0){
            list1.addLast(list2.getHead());
            list2.removeFirst();
        }
        return list1;
    }
    public static int fibonacci(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }
    private static int fib(int term, int val, int prev)
    {
        if(term == 0) return prev;
        if(term == 1) return val+prev;
        return fib(term - 1, val+prev, val);
    }
    public static int fibo(int term){

        return fib(term,1,0);
    }
    static private int awnser=0;

    static SinglyLinkedList reverse(SinglyLinkedList l1){
        return l1;
    }


    public static void main(String[] args) {
    int[][] m={{1,2,3,4},{0,0,0,0},{1,1,1,1}};

        //        try {
//            System.out.print(toInt(s));
//        }
//        catch (Exception e){
//            System.out.println(e.getMessage());
//        }
    	











        /*/ CircularlyLinkedList<Integer> l1=new CircularlyLinkedList<Integer>();
        CircularlyLinkedList<Integer> l2=new CircularlyLinkedList<Integer>();

        for (int i=0;i<10;i++) {
            Integer integer=new Integer(i);
            l1.addFirst(integer);
        }
              ///////////////////////////////////////////////////////////////// Split
        CircularlyLinkedList firstHalf = new CircularlyLinkedList();
        CircularlyLinkedList secondHalf = new CircularlyLinkedList();
        if(!(l1.isEmpty()||((l1.size()%2)!=0))){
            int halfSize = l1.size() / 2;

            if (l1.size() % 2 == 0) {
                for (int i = 0; i < halfSize; i++) {
                    firstHalf.addLast(l1.getTail().getNext().getElement());
                    l1.removeFirst();
                }
                for (int i = halfSize; i <l1.size(); i++) {
                    secondHalf.addLast(l1.getTail().getNext().getElement());
                    l1.removeFirst();
                }

            }
        }/*/

    }

}