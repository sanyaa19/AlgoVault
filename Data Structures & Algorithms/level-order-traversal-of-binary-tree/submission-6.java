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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        List<List<Integer>> list = new ArrayList<>();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            List<Integer> l = new ArrayList<>();

            while(curr != null){
                l.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                curr = q.remove();
            }

            if(!q.isEmpty()) q.add(null);
            list.add(l);
        }

        return list;
    }
}
