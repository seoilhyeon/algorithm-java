package problems.boj.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1517_버블_소트 {

    static int[] tmp;
    static long count;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        tmp = new int[n];
        mergeSort(values, 0, n - 1);

        System.out.println(count);
    }

    private static void mergeSort(int[] A, int s, int e) {
        if (s < e) {
            int m = (s + e) >>> 1;

            mergeSort(A, s, m);
            mergeSort(A, m + 1, e);

            merge(A, s, m, e);
        }
    }

    private static void merge(int[] A, int s, int m, int e) {
        int i = s, j = m + 1, k = s;

        while (i <= m && j <= e) {
            if (A[i] <= A[j]) {
                tmp[k++] = A[i++];
            } else {
                count += j - k;
                tmp[k++] = A[j++];
            }
        }

        while (i <= m) {
            tmp[k++] = A[i++];
        }

        while (j <= e) {
            tmp[k++] = A[j++];
        }

        for (k = s; k <= e; k++) {
            A[k] = tmp[k];
        }
    }
}
