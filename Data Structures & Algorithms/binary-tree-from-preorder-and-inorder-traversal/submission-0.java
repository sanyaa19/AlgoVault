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
    int idx = 0;
    public TreeNode tree(int[] preorder , int start , int end , HashMap<Integer , Integer> map){
        if(start > end) return null;

        int curr = preorder[idx++];
        TreeNode root = new TreeNode(curr);

        int pos = map.get(curr);

        root.left = tree(preorder , start , pos - 1 , map);
        root.right = tree(preorder , pos + 1 , end , map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = 0;
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i] , i);
        }
        return tree(preorder , 0 , inorder.length - 1 , map);
    }
}
