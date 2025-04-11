import java.util.ArrayList;

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
        E last = data.remove(data.size() - 1);
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

    // Métodos auxiliares
    private void upHeap(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (data.get(index).compareTo(data.get(parent)) >= 0)
                break;
            swap(index, parent);
            index = parent;
        }
    }

    private void downHeap(int index) {
        int leftChild;
        while ((leftChild = 2 * index + 1) < data.size()) {
            int smallest = leftChild;
            int rightChild = leftChild + 1;
            if (rightChild < data.size() &&
                    data.get(rightChild).compareTo(data.get(leftChild)) < 0) {
                smallest = rightChild;
            }
            if (data.get(index).compareTo(data.get(smallest)) <= 0)
                break;
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}