package DoublyLinkedList;

public class DoublyLinkedList {

    public class Node {
        int data;
        Node next;
        Node prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }    

    Node head;

    public boolean isEmpty(){
        return head == null;
    }

    public void add(int data){
        Node newNode = new Node(data);

        if (isEmpty()) {
            head = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        head = newNode; 
    }

    public void remove(){
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        Node c = head;
        while (c.next != null) {
            c = c.next;
        }

        c.prev.next = null;
    }

    public void printList(){
        if(isEmpty()){
            System.out.println("List is empty.");
            return;
        }

        Node c = head;
        while (c.next != null) {
            System.out.println(c.data + "->");
            c = c.next;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.printList();
    }
    
}