package problems.leetcode.stackqueue;

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
public class No622_DesignCircularQueue {
    class Solution1 {
        class MyCircularQueue {

            private int[] queue;
            private int front = 0, rear = 0;

            public MyCircularQueue(int k) {
                queue = new int[k + 1];
            }

            public boolean enQueue(int value) {
                if (isFull()) {
                    return false;
                }
                rear = (rear + 1) % queue.length;
                queue[rear] = value;
                return true;
            }

            public boolean deQueue() {
                if (isEmpty()) {
                    return false;
                }
                front = (front + 1) % queue.length;
                return true;
            }

            public int Front() {
                return isEmpty() ? -1 : queue[(front + 1) % queue.length];
            }

            public int Rear() {
                return isEmpty() ? -1 : queue[rear];
            }

            public boolean isEmpty() {
                return front == rear;
            }

            public boolean isFull() {
                return front == (rear + 1) % queue.length;
            }
        }
    }
}
