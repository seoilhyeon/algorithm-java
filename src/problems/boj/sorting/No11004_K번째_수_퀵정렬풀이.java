package problems.boj.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No11004_K번째_수_퀵정렬풀이 {

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        quickSelect(nums, 0, n - 1, k - 1);
        System.out.println(nums[k - 1]);
    }

    private static void quickSelect(int[] a, int l, int r, int k) {
        if (l <= r) {
            int pivot = partition(a, l, r);

            if (pivot == k)
                return;

            if (k < pivot)
                quickSelect(a, l, pivot - 1, k);
            else
                quickSelect(a, pivot + 1, r, k);
        }
    }

    private static int partition(int[] a, int l, int r) {
        int m = (l + r) / 2;
        swap(a, l, m);

        int pivot = a[l], i = l + 1, j = r;
        while (i <= j) {
            while (i <= j && pivot < a[j])
                j--;

            while (i <= j && pivot > a[i])
                i++;

            if (i <= j) {
                swap(a, i++, j--);
            }
        }

        a[l] = a[j];
        a[j] = pivot;
        return j;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
