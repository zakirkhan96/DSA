package Queues;

public class QueuesUsingArray {
    int[] arr;
    int size;
    int rear;
    
        QueuesUsingArray(int size){
            this.arr = new int[size];
            rear = -1;
            this.size = size;
        }
    
        public boolean isEmpty(){
                return rear == -1;
        }
    
        public boolean isFull(){
            return rear == size-1;
        }
    
        public void enqueue(int data){
            if (isEmpty()) {
                rear++;
                arr[rear] = data;
                return;
            }
    
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
    
            rear++;
            arr[rear] = data;
        }
    
        public int dequeue(){
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
    
            int front = arr[0];
            for(int i = 0; i < rear ; i++){
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }
    
        public int peek(){
            if (isEmpty()) {
                System.out.println("Queue is empty.");
                return -1;
            }
    
            return arr[0];
        }
    
        public static void main(String[] args) {
            QueuesUsingArray q1 = new QueuesUsingArray(5);
            q1.enqueue(1);
            q1.enqueue(2);
            q1.enqueue(3);
            q1.enqueue(4);
            q1.enqueue(5);
    
            while (!q1.isEmpty()) {
                System.out.println(q1.peek());
                q1.dequeue();
            }
    }
}