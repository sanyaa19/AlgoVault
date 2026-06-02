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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Deque<TreeNode> dq = new ArrayDeque<>();    //use double ended queue from start we will remove node to add their child at end and after each iteration we check last element to get right most element of that level.
        dq.offer(root);

        while(!dq.isEmpty()){
            int size = dq.size();

            ans.add(dq.peekLast().val);

            for(int i = 0; i < size; i++){
                TreeNode curr = dq.poll();

                if(curr.left != null) dq.offer(curr.left);
                if(curr.right != null) dq.offer(curr.right);
            }
        }

        return ans;
    }
}
