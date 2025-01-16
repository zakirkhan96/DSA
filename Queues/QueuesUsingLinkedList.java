package Queues;

public class QueuesUsingLinkedList {
    class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    class QueueZ {
        Node head = null;
        Node tail = null;

        public boolean isEmpty() {
            return head == null;
        }

        // add new node in queue
        public void enqueue(String value) {
            Node newNode = new Node(value);
            if (tail == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // return and remove node from queue
        public String dequeue() {
            if (isEmpty()) {
                System.out.println("Nothing to remove, queue is empty.");
                return null;
            }
            String removedValue = head.value;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return removedValue;
        }

        // peeking from queue
        public String peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, nothing to show.");
                return null;
            }
            return head.value;
        }

        // printing all nodes from queue
        public void printQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        QueuesUsingLinkedList.QueueZ q3 = new QueuesUsingLinkedList().new QueueZ();
        q3.enqueue("this");
        q3.enqueue("is");
        q3.enqueue("a");
        q3.enqueue("queue");

        System.out.println("Queue contents:");
        q3.printQueue();

        System.out.println("Front of queue: " + q3.peek());

        System.out.println("Removing from queue: " + q3.dequeue());
        System.out.println("Removing from queue: " + q3.dequeue());

        System.out.println("Queue after removing:");
        q3.printQueue();

        System.out.println("First in line now: " + q3.peek());
    }
}
