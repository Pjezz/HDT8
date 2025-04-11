import java.util.*;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private ArrayList<E> data;

    public VectorHeap() {
        data = new ArrayList<>();
    }

    @Override
    public boolean add(E element) {
        data.add(element);
        upHeap(data.size() - 1);
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty())
            return null;
        E min = data.get(0);
        E max = data.remove(data.size() - 1);
        if (!isEmpty()) {
            data.set(0, last);
            downHeap(0);
        }
        return min;
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public int size() {
        return data.size();
    }
}
