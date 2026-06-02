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
    //int count = 0; 
    public int countGood(TreeNode root , int max){
        if(root == null) return 0;

        int count = 0;

        if(root.val >= max){
            max = root.val;
            count++;
        }

        return countGood(root.left , max) + countGood(root.right , max) + count;
    }
    public int goodNodes(TreeNode root) {
        
        return countGood(root , Integer.MIN_VALUE);
    }
}
