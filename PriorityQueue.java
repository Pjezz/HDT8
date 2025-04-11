public interface PriorityQueue<E extends Comparable<E>> {
    boolean add(E element);

    E remove();

    boolean isEmpty();

    int size();
}