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
    public boolean isIdentical(TreeNode root , TreeNode subroot){
        if(subroot == null && root == null) return true;
        
        if(subroot == null || root == null) return false;

        if(root.val == subroot.val){ 
            return isIdentical(root.left , subroot.left) && isIdentical(root.right , subroot.right);
        }
        return false;
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;

        if(root == null) return false;

        if(root.val == subRoot.val){
            if(isIdentical(root , subRoot)) return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
