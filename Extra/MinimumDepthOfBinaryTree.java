package Extra;

import java.util.ArrayDeque;
import java.util.Deque;

// 111. Minimum Depth of Binary Tree
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// Note: A leaf is a node with no children.

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: 2
// Example 2:

// Input: root = [2,null,3,null,4,null,5,null,6]
// Output: 5

// Constraints:

// The number of nodes in the tree is in the range [0, 105].
// -1000 <= Node.val <= 1000

public class MinimumDepthOfBinaryTree {
    public int getMinDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        } else if (root.left == null || root.right == null) {
            if (root.left != null)
                return getMinDepth(root.left, depth + 1);
            if (root.right != null)
                return getMinDepth(root.right, depth + 1);
        } else {
            return Math.min(getMinDepth(root.left, depth + 1), getMinDepth(root.right, depth + 1));
        }
        return -1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        return getMinDepth(root, 1);
    }

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int depth = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        queue.addLast(root);
        queue2.addLast(1);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            depth = queue2.removeFirst();
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.left != null) {
                queue.addLast(node.left);
                queue2.addLast(depth + 1);
            }
            if (node.right != null) {
                queue.addLast(node.right);
                queue2.addLast(depth + 1);
            }
        }

        return depth;
    }
}
