package CircularQueues;

public class CircularQueuesUsingArray {
    int[] arr;
    int size;
    int rear , front;

    CircularQueuesUsingArray(int size){
        this.size = size;
        this.arr = new int[size];
        front = rear = -1;
    }

    public boolean isFull(){
        return (rear + 1) % size == front;
    }

    public boolean isEmpty(){
        return rear == -1 && front == -1;
    }

    public void enqueue(int data){
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        if (isEmpty()) {
            front = 0;
        }

        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    public int dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return -1;
        }

        int res = arr[front];

        if (rear == front) {
            rear = front = -1;
        }else{
            front = (front + 1) % size;
        }

        return res;
    }

    public int peek(){
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arr[front];
    }

    public static void main(String[] args) {
        CircularQueuesUsingArray q2 = new CircularQueuesUsingArray(5);
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        q2.enqueue(4);
        q2.enqueue(5);

        while (!q2.isEmpty()) {
            System.out.print(q2.peek());
            q2.dequeue();
        }

        System.out.println(q2);
    }
}