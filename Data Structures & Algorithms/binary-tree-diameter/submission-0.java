/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxWithRoot = 0;

    public int diameter(TreeNode root , int level){
        if(root == null) return -1;

        level++;

        int leftdepth = diameter(root.left , level) + 1;
        int rightdepth = diameter(root.right , level) + 1;
        int max = Math.max(leftdepth , rightdepth);

        maxWithRoot = Math.max(leftdepth + rightdepth , maxWithRoot);

        if(level == 1){
            return Math.max(max , maxWithRoot);
        }

        return max;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        return diameter(root , 0);
    }
}
