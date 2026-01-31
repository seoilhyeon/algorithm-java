package problems.boj.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No10986_나머지_합 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf((st = new StringTokenizer(br.readLine())).nextToken()),
                m = Integer.valueOf(st.nextToken());
        int[] S = new int[n + 1];
        long[] C = new long[m];
        C[0] = 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            S[i] = (S[i - 1] + Integer.valueOf(st.nextToken()) % m) % m;
            C[S[i]]++;
        }

        long answer = 0;
        for (long c : C) {
            answer += c * (c - 1) / 2;
        }
        bw.append(String.valueOf(answer));
        bw.newLine();
        bw.flush();
    }
}
