package problems.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class No200_NumberOfIslands {

    class Solution1 {
        static final char LAND = '1';
        static final char WATER = '0';
        static final char VISITED = '\0';
        static int[] dx = new int[] { 1, 0, -1, 0 };
        static int[] dy = new int[] { 0, 1, 0, -1 };

        public int numIslands(char[][] grid) {
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != LAND)
                        continue;

                    dfs(grid, i, j);
                    count++;
                }
            }

            return count;
        }

        void dfs(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
                return;

            if (grid[x][y] != LAND)
                return;

            grid[x][y] = VISITED;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                dfs(grid, nx, ny);
            }
        }
    }

    class Solution2 {
        public int numIslands(char[][] grid) {
            final char LAND = '1', WATER = '0', VISITED = '\0';

            int[] dx = new int[] { 1, 0, -1, 0 };
            int[] dy = new int[] { 0, 1, 0, -1 };

            Deque<int[]> dq = new ArrayDeque<>();
            int count = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] != LAND)
                        continue;

                    dq.add(new int[] { i, j });
                    grid[i][j] = VISITED;
                    count++;

                    while (!dq.isEmpty()) {
                        int[] pos = dq.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = pos[0] + dx[dir], ny = pos[1] + dy[dir];
                            if (nx < 0 || nx >= grid.length || ny < 0 || ny >= grid[i].length)
                                continue;

                            if (grid[nx][ny] != LAND)
                                continue;

                            dq.add(new int[] { nx, ny });
                            grid[nx][ny] = VISITED;
                        }
                    }
                }
            }

            return count;
        }
    }
}
