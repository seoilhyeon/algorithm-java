package problems.boj.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class No2750_수_정렬하기 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums)
                .replaceAll("[\\[\\],]", "")
                .replace(' ', '\n'));
    }
}
