package Extra;
// 145. Binary Tree Postorder Traversal

import java.util.LinkedList;
import java.util.List;

// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, return the postorder traversal of its nodes' values.

// Example 1:

// Input: root = [1,null,2,3]

// Output: [3,2,1]

// Explanation:

// Example 2:

// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

// Output: [4,6,7,5,2,9,8,3,1]

// Explanation:

// Example 3:

// Input: root = []

// Output: []

// Example 4:

// Input: root = [1]

// Output: [1]

// Constraints:

// The number of the nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

// Follow up: Recursive solution is trivial, could you do it iteratively?
public class BinaryTreePostOrderTraversal {
    List<Integer> list = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            list.add(root.val);
        }
        return list;

    }

}
// Test Cases
// [1,null,2,3]
// [1,2,3,4,5,null,8,null,null,6,7,9]
// []
// [1]
// [-4, -2, -5, -3, 1]
// [1, 2, 3, 4, 5, 6, 7]
// [1, null, 2, null, 3, null, 4]
// [1, 1, 1, 1, 1, 1, 1]