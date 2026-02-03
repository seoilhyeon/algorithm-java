package problems.boj.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2164_카드2 {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }

        System.out.println(q.peek());
    }
}
