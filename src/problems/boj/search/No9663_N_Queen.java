package problems.boj.search;

import java.util.Scanner;

public class No9663_N_Queen {

    static int count;
    static boolean[] col, diag1, diag2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        col = new boolean[n];
        diag1 = new boolean[2 * n - 1]; // r - c + (n - 1)
        diag2 = new boolean[2 * n - 1]; // r + c

        backtrack(n, 0);

        System.out.println(count);
    }

    private static void backtrack(int n, int r) {
        if (n == r) {
            count++;
            return;
        }

        for (int c = 0; c < n; c++) {
            int d1 = r - c + n - 1, d2 = r + c;
            if (col[c] || diag1[d1] || diag2[d2])
                continue;

            // lock
            col[c] = diag1[d1] = diag2[d2] = true;

            // 실행
            backtrack(n, r + 1);

            // unlock
            col[c] = diag1[d1] = diag2[d2] = false;
        }
    }
}
