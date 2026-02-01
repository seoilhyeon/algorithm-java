package problems.boj.datastructure;

import java.util.Scanner;

public class No2018_수들의_합_5 {
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt(), start = 1, end = 1, sum = 0, count = 1;
        while (end != n + 1) {
            if (sum < n) {
                sum += end;
                end++;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                sum += end;
                end++;
                count++;
            }
        }

        System.out.println(count);
    }
}
