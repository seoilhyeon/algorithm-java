package problems.boj.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class No1377_버블_소트 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(br.readLine());
        IndexedValue[] indexedValues = new IndexedValue[n];

        for (int i = 0; i < n; i++) {
            indexedValues[i] = new IndexedValue(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(indexedValues, Comparator.comparingInt(e -> e.val));

        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            IndexedValue e = indexedValues[i];
            maxDiff = Math.max(maxDiff, e.idx - i);
        }
        sb.append(maxDiff + 1).append("\n");
        bw.append(sb.toString()).close();
    }

    static class IndexedValue {
        int idx;
        int val;

        public IndexedValue(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
}
