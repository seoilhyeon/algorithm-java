package problems.boj.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1940_주몽 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf((st = new StringTokenizer(br.readLine())).nextToken());
        int m = Integer.valueOf((st = new StringTokenizer(br.readLine())).nextToken());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(nums);

        int i = 0, j = n - 1, count = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum < m) {
                i++;
            } else if (sum > m) {
                j--;
            } else {
                count++;
                i++;
            }
        }

        System.out.println(count);
    }
}
