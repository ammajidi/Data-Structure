
import java.util.AbstractQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MergeSort<E> {
    public static <E> void sort(E[] s, Comparator<E> comp) {
        int l = s.length;
        if (l < 2) return;
        int mid = l / 2;
        E[] s1 = Arrays.copyOfRange(s, 0, mid);
        E[] s2 = Arrays.copyOfRange(s, mid, l);
        sort(s1, comp);
        sort(s2, comp);
        merge(s1, s2, s, comp);
    }

    public static <E> void merge(E[] s1, E[] s2, E[] s, Comparator comp) {
        int i=0; int j = 0;
        while (i + j < s.length){
            if (j==s2.length ||i<s1.length&&comp.compare(s2[j],s1[i])<0){
                s[i+j]=s1[i];
                i++;
            }
            else
            {
                s[i+j]=s2[j];
                j++;
            }
        }
    }
    public  static <E> void quickSort(AbstractQueue<E> s, Comparator<E> comparator){
        int n=s.size();
        if (n<2)return;
        AbstractQueue<E> l=new AbstractQueue<E>() {
            @Override
            public Iterator<E> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean offer(E e) {
                return false;
            }

            @Override
            public E poll() {
                return null;
            }

            @Override
            public E peek() {
                return null;
            }
        };
        AbstractQueue<E> e=new AbstractQueue<E>() {
            @Override
            public Iterator<E> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean offer(E e) {
                return false;
            }

            @Override
            public E poll() {
                return null;
            }

            @Override
            public E peek() {
                return null;
            }
        };
        AbstractQueue<E> g=new AbstractQueue<E>() {
            @Override
            public Iterator<E> iterator() {
                return null;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean offer(E e) {
                return false;
            }

            @Override
            public E poll() {
                return null;
            }

            @Override
            public E peek() {
                return null;
            }
        };
        while (!s.isEmpty()){
//to be continued..
        }
    }
}
