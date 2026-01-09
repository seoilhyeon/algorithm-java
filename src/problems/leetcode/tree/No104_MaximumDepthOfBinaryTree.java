package problems.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

import types.leetcode.TreeNode;

public class No104_MaximumDepthOfBinaryTree {
    /**
     * 레벨 순회 (BFS)
     * queue <- TreeNode, level
     */
    class Solution1 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            int depth = 0;
            queue.add(root);

            while (!queue.isEmpty()) {
                depth++;
                int qSize = queue.size();
                for (int i = 0; i < qSize; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
            }

            return depth;
        }
    }

    /**
     * DFS
     */
    class Solution2 {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = maxDepth(root.left) + 1;
            int right = maxDepth(root.right) + 1;
            return Math.max(left, right);
        }
    }
}
