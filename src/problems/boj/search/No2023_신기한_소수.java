package problems.boj.search;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class No2023_신기한_소수 {

    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 1; i < 10; i++) {
            if (isPrime(i)) {
                backtrack(i, 1, n);
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(sb.toString()).close();
    }

    private static void backtrack(int num, int depth, int limit) {
        if (depth >= limit) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 0; i < 10; i++) {
            int next = 10 * num + i;
            if (isPrime(next)) {
                backtrack(next, depth + 1, limit);
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }

        return n != 1;
    }
}
