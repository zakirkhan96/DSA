package Queues;

public class CircularQueueUsingLinkedList {
    class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    class CircularQueue {
        Node tail = null;

        public boolean isEmpty() {
            return tail == null;
        }

        public void enqueue(String value) {
            Node newNode = new Node(value);

            if (isEmpty()) {
                tail = newNode;
                tail.next = newNode; 
                return;
            }

            newNode.next = tail.next; 
            tail.next = newNode; 
            tail = newNode;
        }

        public String dequeue() {
            if (isEmpty()) {
                System.out.println("Nothing to remove, queue is empty.");
                return null;
            }

            Node head = tail.next;
            String removedValue = head.value;

            if (head == tail) { 
                tail = null;
            } else {
                tail.next = head.next; 
            }

            return removedValue;
        }

        public String peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty, nothing to show.");
                return null;
            }
            return tail.next.value;
        }

        public void printQueue() {
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return;
            }

            Node current = tail.next; 
            do {
                System.out.print(current.value + " ");
                current = current.next;
            } while (current != tail.next); 

            System.out.println();
        }
    }

    public static void main(String[] args) {
        CircularQueueUsingLinkedList.CircularQueue queue = new CircularQueueUsingLinkedList().new CircularQueue();

        queue.enqueue("This");
        queue.enqueue("is");
        queue.enqueue("also");
        queue.enqueue("a");
        queue.enqueue("Linked-List+queue.");
        queue.printQueue();
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println("Queue after removing:");
        queue.printQueue();
        System.out.println("Front in queue now: " + queue.peek());
        queue.enqueue("ba");
        queue.enqueue("bye.");
        System.out.println("Queue after adding more people:");
        queue.printQueue();
    }
}
