/**
 * PriorityQueue
 */
public class PriorityQueue {
    private MinHeap<Node> queue;

    public PriorityQueue() {
        queue = new LinkedList<>();
    }

    class Node {
        Integer priority;
        int value;

        public Node(Integer priority, int value) {
            this.priority = priority;
            this.value = value;
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