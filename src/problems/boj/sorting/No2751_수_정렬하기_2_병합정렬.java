package problems.boj.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No2751_수_정렬하기_2_병합정렬 {
    static int[] tmp;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        tmp = new int[n];
        mergeSort(a, 0, a.length - 1);

        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append("\n");
        }
        bw.append(sb.toString()).close();
    }

    private static void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);

            merge(A, left, mid, right);
        }
    }

    private static void merge(int[] A, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (A[i] <= A[j]) {
                tmp[k++] = A[i++];
            } else {
                tmp[k++] = A[j++];
            }
        }

        while (i <= mid) {
            tmp[k++] = A[i++];
        }
        while (j <= right) {
            tmp[k++] = A[j++];
        }

        for (int idx = left; idx <= right; idx++) {
            A[idx] = tmp[idx];
        }
    }
}
