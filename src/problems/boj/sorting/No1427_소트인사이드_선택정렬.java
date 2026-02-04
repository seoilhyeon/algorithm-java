package problems.boj.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class No1427_소트인사이드_선택정렬 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        List<Integer> nums = new ArrayList<>();

        int c;
        while ((c = br.read()) != '\n') {
            nums.add(c - '0');
        }

        for (int i = 0; i < nums.size(); i++) {
            int idx = i;
            for (int j = i + 1; j < nums.size(); j++) {
                if (nums.get(idx) < nums.get(j)) {
                    idx = j;
                }
            }

            int temp = nums.get(i);
            nums.set(i, nums.get(idx));
            nums.set(idx, temp);
        }

        for (int e : nums) {
            sb.append(e);
        }
        bw.append(sb.toString()).append("\n").close();
    }
}
