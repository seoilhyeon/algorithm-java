package problems.boj.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No11399_ATM_삽입정렬풀이 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (p[j - 1] <= p[j])
                    break;

                int temp = p[j];
                p[j] = p[j - 1];
                p[j - 1] = temp;
            }
        }

        int acc = 0, answer = 0;
        for (int time : p) {
            acc += time;
            answer += acc;
        }
        bw.append(Integer.toString(answer)).append("\n").close();
    }
}
