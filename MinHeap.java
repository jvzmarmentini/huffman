import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> minHeap;

    public MinHeap(int length) {
        minHeap = new ArrayList<>(length);
    }

    /**
     * 
     * @param child
     * @param parent
     */
    private void swap(int child, int parent) {
        T e = minHeap.get(parent);
        minHeap.set(parent, minHeap.get(child));
        minHeap.set(child, e);
    }

    /**
     * Insere um valor inteiro no heap.
     * 
     * @param n o número a ser inserido.
     */
    public void insert(T e) {
        minHeap.add(e);
        heapifyUp(minHeap.size() - 1);
    }

    /**
     * 
     * @param pos
     */
    private void heapifyUp(int child) {
        int parent = Math.floorDiv(child - 1, 2);

        if (child > 0 && minHeap.get(child).compareTo(minHeap.get(parent)) < 0) {
            swap(child, parent);
            heapifyUp(parent);
        }

    }

    /**
     * Método para a remoção e retorno do menor elemento do heap. Caso o heap esteja
     * vazio, um valor null deve ser retornado.
     * 
     * @return o menor valor do heap.
     */
    public T removeMin() {
        if (isEmpty())
            return null;
        T removed = minHeap.get(0);
        swap(0, minHeap.size() - 1);
        minHeap.remove(minHeap.size() - 1);
        heapfyDown(0);
        return removed;
    }

    /**
     * 
     * @param parent
     */
    private void heapfyDown(int parent) {
        int sChild; // menor filho
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if (2 * parent + 1 < minHeap.size() - 1) { // dois filhos
            sChild = minHeap.get(left).compareTo(minHeap.get(right)) > 0 ? right : left;
        } else if (2 * parent + 1 == minHeap.size() - 1) // um filhos
            sChild = 2 * parent + 1;
        else
            return;
        if (minHeap.get(sChild).compareTo(minHeap.get(parent)) < 0) {
            swap(sChild, parent);
            heapfyDown(sChild);
        }
    }

    /**
     * Método que acessa e retorna do menor elemento do heap. Caso o heap esteja
     * vazio, um valor null deve ser retornado.
     * 
     * @return o menor valor do heap.
     */
    public T min() {
        return (isEmpty()) ? null : minHeap.get(0);
    }

    /**
     * Retorna o tamanho do heap em número de elementos dentro do heap.
     * 
     * @return number of items
     */
    public Integer length() {
        return (isEmpty()) ? null : minHeap.size();
    }

    /**
     * Testa se o heap é vazio.
     * 
     * @return true caso o heap esteja vazio, false caso contrário.
     */
    boolean isEmpty() {
        return minHeap.isEmpty();
    }

    @Override
    public String toString() {
        return minHeap + "";
    }
}
