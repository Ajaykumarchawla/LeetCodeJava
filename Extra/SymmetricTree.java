package Extra;

// 101. Symmetric Tree

// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Example 1:

// Input: root = [1,2,2,3,4,4,3]
// Output: true
// Example 2:

// Input: root = [1,2,2,null,3,null,3]
// Output: false

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// -100 <= Node.val <= 100

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class SymmetricTree {
    public boolean ifBothSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true; // if both null return true
        if (left == null || right == null)
            return false; // if any of them is null return false
        if (left.val != right.val)
            return false; // if value is not matching return false

        return (ifBothSymmetric(left.left, right.right) && ifBothSymmetric(left.right, right.left));
    };

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return ifBothSymmetric(root.left, root.right);
    }

}

// Test Cases
//
// [1,2,2,3,4,4,3]
// [1,2,2,null,3,null,3]
// [1,2,2,3,4,4,3]
// [1,2,2,null,3,null,3]
// [1,2,2,2,null,2]
// [1,2,2,5,null,null,5,6,null,null,6]
// [1,2,3]
// [1]