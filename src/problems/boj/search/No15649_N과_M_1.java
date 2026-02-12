package problems.boj.search;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class No15649_N과_M_1 {

    static Scanner scanner = new Scanner(System.in);
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder();
    static int[] buffer;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt(), m = scanner.nextInt();
        buffer = new int[m];
        used = new boolean[n + 1];

        backtrack(n, m, 0);
        bw.append(sb.toString()).close();
    }

    private static void backtrack(int n, int m, int k) {
        if (k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(buffer[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (used[i])
                continue;

            buffer[k] = i;
            used[i] = true;
            backtrack(n, m, k + 1);
            used[i] = false;
        }
    }
}
