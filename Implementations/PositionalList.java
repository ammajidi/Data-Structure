

public interface PositionalList<E> {
    int size();
    boolean isEmpty();
    Position first();
    Position last();
    Position before(Position p) throws IllegalArgumentException;
    Position after(Position p) throws IllegalArgumentException;
    Position addFirst(Position e);
    Position addLast(Position e);
    Position addBefore(Position p, E e) throws IllegalArgumentException;
    E set(Position<E> p, E e) throws IllegalArgumentException;
    E remove(Position p) throws IllegalArgumentException;
}
