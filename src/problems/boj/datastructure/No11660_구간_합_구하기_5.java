package problems.boj.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No11660_구간_합_구하기_5 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf((st = new StringTokenizer(br.readLine())).nextToken()),
                m = Integer.valueOf(st.nextToken());
        int[][] D = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + Integer.valueOf(st.nextToken());
            }
        }

        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(st.nextToken()), y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken()), y2 = Integer.valueOf(st.nextToken());
            bw.append(String.valueOf(D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]))
                    .append("\n");
        }
        bw.flush();
    }
}
