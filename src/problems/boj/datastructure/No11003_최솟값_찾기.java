package problems.boj.datastructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class No11003_최솟값_찾기 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int idx;
        int val;

        public Node(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = Integer.valueOf((st = new StringTokenizer(br.readLine())).nextToken()),
                l = Integer.valueOf(st.nextToken());

        Deque<Node> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Node node = new Node(i, Integer.valueOf(st.nextToken()));

            while (!dq.isEmpty() && dq.peekLast().val >= node.val) {
                dq.pollLast();
            }

            while (!dq.isEmpty() && i - dq.peekFirst().idx + 1 > l) {
                dq.pollFirst();
            }

            dq.addLast(node);

            sb.append(dq.peekFirst().val).append(' ');
        }
        bw.append(sb.append("\n").toString());
        bw.close();
    }
}
