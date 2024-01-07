package RecursionI;
// Given an integer n, return all the structurally unique BST's (binary search trees), which has exactly n nodes of unique values from 1 to n. Return the answer in any order.

import java.util.ArrayList;
import java.util.List;

// Example 1:

// Input: n = 3
// Output: [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
// Example 2:

// Input: n = 1
// Output: [[1]]

// Constraints:

// 1 <= n <= 8
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        return generateBranch(1, n);

    }

    public List<TreeNode> generateBranch(int min, int max) {
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        if (min == max) {
            TreeNode node = new TreeNode(min);
            list1.add(node);
            return list1;
        }
        for (int i = min; i <= max; i++) {
            List<TreeNode> leftNodes = generateBranch(min, i - 1);
            List<TreeNode> RightNodes = generateBranch(i + 1, max);

            if (leftNodes.size() == 0) {
                for (TreeNode r : RightNodes) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.right = r;
                    list1.add(newNode);
                }
                continue;
            }
            if (RightNodes.size() == 0) {
                for (TreeNode l : leftNodes) {
                    TreeNode newNode = new TreeNode(i);

                    newNode.left = l;
                    list1.add(newNode);
                }
                continue;
            }
            for (TreeNode l : leftNodes) {
                for (TreeNode r : RightNodes) {
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = l;
                    newNode.right = r;
                    list1.add(newNode);

                }
            }
        }
        return list1;
    }
}
