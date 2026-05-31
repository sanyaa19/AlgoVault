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


// //Recurssive solution (Recurssive DFS) Time:O(n) Space:O(h) due to recurssive stack
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root == null) return 0;

//         int leftDepth = maxDepth(root.left);
//         int rightDepth = maxDepth(root.right);

//         return Math.max(leftDepth , rightDepth) + 1;
//     }
// }


// //Iterative Solution (BFS) Time: O(n) Space: O(n) due to queue
class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null) return depth;

        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            for(int i = 0; i < size; i++){
                TreeNode curr = q.remove();

                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
        }

        return depth;
    }
}


