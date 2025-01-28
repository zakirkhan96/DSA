package DoublyLinkedList;

public class CircularDoublyLinkedList {
    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;

    public boolean isEmpty() {
        return head == null;
    }

    public void add(int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void remove() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) {
            head = null;
        } else {
            Node tail = head.prev;
            tail.prev.next = head;
            head.prev = tail.prev;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        do {
            System.out.print(current.data + " <-> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.printList(); 

        list.remove();
        list.printList(); 

        list.remove();
        list.printList(); 

        list.remove();
        list.printList();
    }
}