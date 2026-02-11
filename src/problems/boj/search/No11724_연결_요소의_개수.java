package problems.boj.search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class No11724_연결_요소의_개수 {

    static List<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            count++;
            dfs(i, visited);
        }

        System.out.println(count);
    }

    private static void dfs(int node, boolean[] visited) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (visited[next])
                continue;

            dfs(next, visited);
        }
    }
}
