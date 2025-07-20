package Extra;
// Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

// Example 1:

// Input: nums = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: [0,-10,5,null,-3,null,9] is also accepted:

// Example 2:

// Input: nums = [1,3]
// Output: [3,1]
// Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

// Constraints:

// 1 <= nums.length <= 104
// -104 <= nums[i] <= 104
// nums is sorted in a strictly increasing order.

//Definition for a binary tree node.
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

public class CovertedSortedArraytoBinarySearchTree {
    public TreeNode convertToBST(int[] nums, int i, int n) {
        if (i > n) {
            return null;
        }
        if (i == n) {
            return new TreeNode(nums[i]);
        } else {
            int index = (i + n) / 2 + (i + n) % 2;

            TreeNode node = new TreeNode(nums[index]);
            node.left = convertToBST(nums, i, index - 1);
            node.right = convertToBST(nums, index + 1, n);

            return node;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return convertToBST(nums, 0, nums.length - 1);
    }
}
// Test cases
// [-10,-3,0,5,9]
// [1,3]
// [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
// [1]
// [0,1,2,3,4,5]
// [-1, 0, 1, 2]