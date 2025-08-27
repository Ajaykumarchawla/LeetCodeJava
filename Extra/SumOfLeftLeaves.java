package Extra;

// Given the root of a binary tree, return the sum of all left leaves.

// A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

// Example 1:

// Input: root = [3,9,20,null,null,15,7]
// Output: 24
// Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
// Example 2:

// Input: root = [1]
// Output: 0

// Constraints:

// The number of nodes in the tree is in the range [1, 1000].
// -1000 <= Node.val <= 1000

public class SumOfLeftLeaves {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum = sum + root.left.val;

        }
        if (root.left != null)
            sumOfLeftLeaves(root.left);

        if (root.right != null)
            sumOfLeftLeaves(root.right);

        return sum;
    }
}

// Test Cases:
// [0,2,4,1,null,3,-1,5,1,null,6,null,8]
// [1,2,3,4,5]
// [500]
// [-9,-3,2,null,4,4,0,-6,null,-5]
// [1,null,2,null,3,null,4,null,5]
// [1,null,2,null,3,null,4,5]
// [1,2,null,3,null,4,null,5]
// [1,2,null,3,null,4,null,null,5]
