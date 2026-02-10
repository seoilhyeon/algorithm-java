package problems.boj.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No10989_수_정렬하기_3 {

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        radixSort(nums, 5);

        for (int i = 0; i < n; i++) {
            sb.append(nums[i]).append("\n");
        }

        bw.append(sb.toString()).close();
    }

    private static void radixSort(int[] nums, final int MAX_SIZE) {
        int[] output = new int[nums.length];
        int jarisu = 1, count = 0;

        while (count != MAX_SIZE) {
            int[] bucket = new int[10];
            for (int i = 0; i < nums.length; i++) {
                bucket[nums[i] / jarisu % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                output[bucket[nums[i] / jarisu % 10]-- - 1] = nums[i];
            }

            for (int i = 0; i < nums.length; i++) {
                nums[i] = output[i];
            }
            jarisu *= 10;
            count++;
        }

    }
}
