package problems.boj.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No11659_구간_합_구하기_4 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf((st = new StringTokenizer(br.readLine())).nextToken()),
                m = Integer.valueOf(st.nextToken());
        int[] prefix = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            prefix[i] = Integer.valueOf(st.nextToken()) + prefix[i - 1];
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.valueOf(st.nextToken()), j = Integer.valueOf(st.nextToken());
            bw.append(String.valueOf(prefix[j] - prefix[i - 1]))
                    .append("\n");
        }
        bw.flush();
    }
}
