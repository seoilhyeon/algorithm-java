package problems.leetcode.stackqueue;

public class No622_DesignCircularQueue {

    /**
     * Your MyCircularQueue object will be instantiated and called as such:
     * MyCircularQueue obj = new MyCircularQueue(k);
     * boolean param_1 = obj.enQueue(value);
     * boolean param_2 = obj.deQueue();
     * int param_3 = obj.Front();
     * int param_4 = obj.Rear();
     * boolean param_5 = obj.isEmpty();
     * boolean param_6 = obj.isFull();
     */
    class MyCircularQueue {

        int[] store;
        int front, rear, size;

        public MyCircularQueue(int k) {
            this.size = k + 1;
            this.store = new int[size];
        }

        public boolean enQueue(int value) {
            if (isFull())
                return false;

            rear = (rear + 1) % size;
            store[rear] = value;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty())
                return false;

            front = (front + 1) % size;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : store[(front + 1) % size];
        }

        public int Rear() {
            return isEmpty() ? -1 : store[rear];
        }

        public boolean isEmpty() {
            return front == rear;
        }

        public boolean isFull() {
            return front == (rear + 1) % size;
        }
    }
}
