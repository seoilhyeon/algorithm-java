package problems.boj.datastructure;

import java.io.IOException;
import java.util.Scanner;

public class No11720_숫자의_합 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int sum = 0;
        for (char c : sc.next().toCharArray()) {
            sum += c - '0';
        }
        System.out.println(sum);
    }
}
