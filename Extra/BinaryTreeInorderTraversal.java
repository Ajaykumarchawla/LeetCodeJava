package Extra;

import java.util.LinkedList;
import java.util.List;

// 94. Binary Tree Inorder Traversal
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, return the inorder traversal of its nodes' values.

// Example 1:

// Input: root = [1,null,2,3]

// Output: [1,3,2]

// Explanation:

// Example 2:

// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

// Output: [4,2,6,5,7,1,3,9,8]

// Explanation:

// Example 3:

// Input: root = []

// Output: []

// Example 4:

// Input: root = [1]

// Output: [1]

// Constraints:

// The number of nodes in the tree is in the range [0, 100].
// -100 <= Node.val <= 100

// Follow up: Recursive solution is trivial, could you do it iteratively?

public class BinaryTreeInorderTraversal {
    public void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        } else {
            traverse(root.left, list);
            list.add(root.val);
            traverse(root.right, list);
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        traverse(root, list);
        return list;
    }
}

// Test cases
//
// [-26]
// [100,8,null,-83,null,48,null,72,null,-4]
// [97,78,32,80,79,29,-29,null,45,null,-20,null,-20,13,null,97,-41,-100,94,null]
// [73,-55,76,null,71,-71,72,null,-63,null,-34,null,-9,null,-98,-19,-87,-83,63,-70,null,77,null,-36,null,-77,6,null,29,null]
// [-72,11,-94,null,3,76,null,51,71,19,null,89,-62,null,-13,84,null,-66,55,-10,null,-99,-55,5,-40,20,null,-6,null,-60,null,39,null,38,-95,57,null,40,null,38]
// [52,null,13,null,52,null,47,null,-75,-16,null,-10,null,7,99,10,null,20,null,15,-100,null,-37,67,0,-86,null,-96,25,null,68,-20,25,-28,-94,null,37,-22,null,65,-72,-24,null,90,19,null,86,-40,null,-7]
// [36,null,9,null,62,66,null,56,97,55,null,51,-21,null,81,62,-88,null,-67,-40,null,-61,null,-79,98,null,37,-42,-60,-61,null,-70,-47,null,67,90,22,27,null,88,-34,null,43,67,-10,null,73,null,42,null,-21,1,-46,-58,null,33,null,72,-20,null,82,-23,null,87,27,null,-34,62,60,null,-49,null,-74,-5,null,49,null,-85,36,5,60,null,71,59,57,null,-68,55,null,-36,11,-18,null,-87,-91,null,-74,null,-17,-25]
// [9,null,34,6,-17,null,-94,-54,60,-99,-30,null,100,null,-16,57,null,-90,-11,null,-17,null,-72,null,70,null,56,null,4,-65,null,-75,null,20,71,null,1,-7,-54,30,null,66,null,59,98,null,31,78,-7,-87,null,-4,25,96,-56,null,39,-63,null,-95,null,-37,80,null,-52,null,-85,31,null,51,null,3,82,null,-50,null,95,60,null,49,75,null,91,36,null,-27,null,-87,-13,null,96,null,87,null,19,null,-96,-69,null,-2]