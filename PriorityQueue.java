/**
 * PriorityQueue
 */
public class PriorityQueue {
    private MinHeap<Node> queue;

    public PriorityQueue(int length) {
        queue = new MinHeap<>(length);
    }

    class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        Integer priority;
        T value;

        public Node(Integer priority, T value) {
            this.priority = priority;
            this.value = value;
        }

        @Override
        public int compareTo(Node<T> other) {
            return priority.compareTo(other.priority);
        }
    }

    public void insert(Node node) {
        queue.add(node);
    }

    public Node pull() {
        Node highest = new Node(Integer.MIN_VALUE, 0);

        for (Node node : queue) {
            if (highest.priority < node.priority) {
                highest = node;
            }
        }

        queue.remove(highest);

        return highest;
    }
}