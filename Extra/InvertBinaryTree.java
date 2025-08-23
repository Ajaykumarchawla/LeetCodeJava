package Extra;

// 226. Invert Binary Tree

// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, invert the tree, and return its root.

// Example 1:

// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]
// Example 2:

// Input: root = [2,1,3]
// Output: [2,3,1]
// Example 3:

// Input: root = []
// Output: []

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);

        return root;
    }
}
// Test Cases:
// [4,2,7,1,3,6,9]
// [2,1,3]
// []
// [2, null ,1]
// [2,1]
// [1,2,3, 61, 4, 7, 14, 9 , null, 10, null, null]
