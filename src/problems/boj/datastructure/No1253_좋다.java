package problems.boj.datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1253_좋다 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf((st = new StringTokenizer(br.readLine())).nextToken());
        int[] nums = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.valueOf(st.nextToken());
        }

        Arrays.sort(nums);

        int count = 0;
        for (int k = 0; k < n; k++) {
            int i = 0, j = n - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum == nums[k]) {
                    if (i != k && j != k) {
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else {
                        j--;
                    }
                } else if (sum < nums[k]) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        System.out.println(count);
    }
}
