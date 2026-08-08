package problems.leetcode.stackqueue;

public class No641_DesignCircularDeque {

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    class MyCircularDeque {

        int[] store;
        int size, front, rear;

        public MyCircularDeque(int k) {
            this.size = k + 1;
            store = new int[size];
        }

        public boolean insertFront(int value) {
            if (isFull())
                return false;

            store[front] = value;
            front = (front + size - 1) % size;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull())
                return false;

            rear = (rear + 1) % size;
            store[rear] = value;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty())
                return false;

            front = (front + 1) % size;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty())
                return false;

            rear = (rear + size - 1) % size;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : store[(front + 1) % size];
        }

        public int getRear() {
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
