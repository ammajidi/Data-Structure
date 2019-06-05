import java.util.Comparator;


public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V>,Comparable<K>{
    protected static class PQEntry<K, V> implements Entry<K, V> {
        K key;
        V value;

        public PQEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        protected void setKey(K key) {
            this.key = key;
        }

        protected void setValue(V value) {
            this.value = value;
        }
    }
    private Comparator<K> comp;
    //∗∗ Creates an empty priority queue using the given comparator to order keys. ∗/
    protected AbstractPriorityQueue(Comparator<K> c) {
        comp = c;
    }

    //∗∗ Creates an empty priority queue based on the natural ordering of its keys. ∗/
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<K>());
    }

    //∗∗ Method for comparing two entries according to key ∗/
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    //∗∗ Determines whether a key is valid. ∗/
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0); // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    //∗∗ Tests whether the priority queue is empty. ∗/
    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        AbstractPriorityQueue a=new AbstractPriorityQueue() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Entry insert(Object key, Object value) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Entry min() {
                return null;
            }

            @Override
            public Entry removeMin() {
                return null;
            }
        };

    }
}


