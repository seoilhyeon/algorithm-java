package problems.leetcode.hashtable;

import java.util.Arrays;

public class No706_DesignHashMap {

    /**
     * Your MyHashMap object will be instantiated and called as such:
     * MyHashMap obj = new MyHashMap();
     * obj.put(key,value);
     * int param_2 = obj.get(key);
     * obj.remove(key);
     */
    class MyHashMap {

        int[] store = new int[1000001];

        public MyHashMap() {
            Arrays.fill(store, -1);
        }

        public void put(int key, int value) {
            store[key] = value;
        }

        public int get(int key) {
            return store[key];
        }

        public void remove(int key) {
            store[key] = -1;
        }
    }
}
