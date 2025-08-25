package Extra;
// 257. Binary Tree Paths
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the root of a binary tree, return all root-to-leaf paths in any order.

// A leaf is a node with no children.

 

// Example 1:


// Input: root = [1,2,3,null,5]
// Output: ["1->2->5","1->3"]
// Example 2:

// Input: root = [1]
// Output: ["1"]
 

// Constraints:

// The number of nodes in the tree is in the range [1, 100].
// -100 <= Node.val <= 100

class BinaryTreePaths{
    List<String> strList = new ArrayList<>();
    StringBuilder str = new StringBuilder();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){
            return strList;
        }else{
            int oldLength = str.length();
            str.append(root.val);
            if(root.left == null && root.right == null)
                strList.add(str.toString());
            str.append("->");
            binaryTreePaths(root.left);
            binaryTreePaths(root.right);
            str.delete(oldLength,str.length());
            return strList;
        }
    }
}

// Test Cases:
// [1,2,3,null,5]
// [1]
// [1,2,3,4,5,6,7,8,9,10]
// [1,null,2,null,6,4,5]
// [37,-34,-48,null,-100,-100,48,null,null,null,null,-54,null,-71,-22,null,null,null,8]