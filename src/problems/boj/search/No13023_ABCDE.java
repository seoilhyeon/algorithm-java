package problems.boj.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No13023_ABCDE {

    static List<Integer>[] graph;
    static boolean isPresent;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            dfs(i, visited, 1);
        }

        if (isPresent)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static void dfs(int node, boolean[] visited, int k) {
        if (k >= 5 || isPresent) {
            isPresent = true;
            return;
        }

        visited[node] = true;

        for (int next : graph[node]) {
            if (visited[next])
                continue;

            dfs(next, visited, k + 1);
        }

        visited[node] = false;
    }
}
