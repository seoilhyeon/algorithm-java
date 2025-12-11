package problems.leetcode.graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class No200_NumberOfIslands {
    class Solution1 {

        public int numIslands(char[][] grid) {
            final char ISLAND = '1';
            final char WATER = '0';

            int[] dx = new int[] { 1, 0, -1, 0 };
            int[] dy = new int[] { 0, 1, 0, -1 };
            boolean[][] visited = new boolean[grid.length][grid[0].length];

            Deque<int[]> stack = new ArrayDeque<>();
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (visited[i][j] || grid[i][j] == WATER) {
                        continue;
                    }
                    stack.push(new int[] { i, j });

                    while (!stack.isEmpty()) {
                        int[] pos = stack.pop();
                        visited[pos[0]][pos[1]] = true;

                        for (int idx = 0; idx < 4; idx++) {
                            int nx = pos[1] + dx[idx], ny = pos[0] + dy[idx];
                            if (ny < 0 || ny >= grid.length || nx < 0 || nx >= grid[0].length) {
                                continue;
                            }
                            if (visited[ny][nx] || grid[ny][nx] == WATER) {
                                continue;
                            }
                            stack.push(new int[] { ny, nx });
                        }
                    }

                    count++;
                }
            }

            return count;
        }
    }

    class Solution2 {

        private final char VISITED = '\0';
        private final char WATER = '0';
        private final char LAND = '1';

        private final int[] dx = { 1, 0, -1, 0 };
        private final int[] dy = { 0, 1, 0, -1 };

        public int numIslands(char[][] grid) {
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == VISITED || grid[i][j] == WATER) {
                        continue;
                    }
                    dfs(grid, j, i);
                    count++;
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int x, int y) {
            if (x < 0 || x >= grid[0].length || y < 0 || y >= grid.length) {
                return;
            }
            if (grid[y][x] == VISITED || grid[y][x] == WATER) {
                return;
            }

            grid[y][x] = VISITED;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                dfs(grid, nx, ny);
            }
        }
    }
}
