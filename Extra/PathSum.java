package Extra;

// 112. Path Sum
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

// A leaf is a node with no children.

// Example 1:

// Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
// Output: true
// Explanation: The root-to-leaf path with the target sum is shown.
// Example 2:

// Input: root = [1,2,3], targetSum = 5
// Output: false
// Explanation: There are two root-to-leaf paths in the tree:
// (1 --> 2): The sum is 3.
// (1 --> 3): The sum is 4.
// There is no root-to-leaf path with sum = 5.
// Example 3:

// Input: root = [], targetSum = 0
// Output: false
// Explanation: Since the tree is empty, there are no root-to-leaf paths.

// Constraints:

// The number of nodes in the tree is in the range [0, 5000].
// -1000 <= Node.val <= 1000
// -1000 <= targetSum <= 1000
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
            return targetSum - root.val == 0;

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSumDFS(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        if (targetSum - root.val == 0 && root.left == null && root.right == null)
            return true;

        if (hasPathSum(root.left, targetSum - root.val)) {
            return true;
        }
        if (hasPathSum(root.right, targetSum - root.val)) {
            return true;
        }

        return false;
    }

}

// Test Cases

// [10,2,11,0]
// 12
// [1,2,3]
// 5
// [0]
// 0
// [1,2]
// 1
// [1,2]
// 2
// [-2,null,-3]
// -5
// [-2,null,-3]
// 0
// []
// 1