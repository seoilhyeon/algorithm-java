package problems.boj.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class No12891_DNA_비밀번호 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {
        int s = Integer.valueOf((st = new StringTokenizer(br.readLine())).nextToken()),
                p = Integer.valueOf(st.nextToken());
        char[] dna = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        int[] req = new int[4];
        for (int i = 0; i < 4; i++) {
            req[i] = Integer.valueOf(st.nextToken());
        }

        int i = 0, j = 0, answer = 0;
        int[] count = new int[4];
        while (j < s) {
            char in = dna[j];
            count[idx(in)]++;
            j++;

            if (j - i == p) {
                boolean isMatch = true;
                for (int k = 0; k < 4; k++) {
                    if (req[k] > count[k]) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    answer++;
                }

                char out = dna[i];
                count[idx(out)]--;
                i++;
            }
        }

        bw.append(Integer.toString(answer));
        bw.newLine();
        bw.close();
    }

    static int idx(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'C':
                return 1;
            case 'G':
                return 2;
            case 'T':
                return 3;
        }
        return -1;
    }
}
