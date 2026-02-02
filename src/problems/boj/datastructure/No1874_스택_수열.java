package problems.boj.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class No1874_스택_수열 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(br.readLine());
        }

        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            while (!dq.isEmpty() && dq.peek() == arr[idx]) {
                sb.append("-").append("\n");
                dq.pop();
                idx++;
            }

            sb.append("+").append("\n");
            dq.push(i);
        }

        while (!dq.isEmpty() && dq.peek() == arr[idx]) {
            sb.append("-").append("\n");
            dq.pop();
            idx++;
        }

        if (!dq.isEmpty()) {
            bw.append("NO");
        } else {
            bw.append(sb.toString());
        }

        bw.close();
    }
}
