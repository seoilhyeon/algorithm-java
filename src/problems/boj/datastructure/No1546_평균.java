package problems.boj.datastructure;

import java.util.Arrays;
import java.util.Scanner;

public class No1546_평균 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt(), m = 0;
        int[] scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
            m = Math.max(m, scores[i]);
        }

        int sum = Arrays.stream(scores)
                .reduce(0, (a, b) -> a + b);
        System.out.println(sum * 100.0 / m / n);
    }
}
