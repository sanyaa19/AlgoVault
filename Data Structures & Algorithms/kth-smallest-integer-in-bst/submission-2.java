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
    int count = 0;
    int result = -1;
    public void inorder(TreeNode root , int k){
        if(root == null) return;

        inorder(root.left , k);

        count++;
        if(count == k){
            result = root.val;
        }

        inorder(root.right , k);
    }
    public int kthSmallest(TreeNode root, int k) {
        //if it's bst then left most element will be smallest; 
        //left < node < right at any node this will be the arrangement;
        //so we can use inorder traversal that will give result in exactly this format
        //we can keep a count how many elemens we have seen then at k'th element we will return the value;
        
        inorder(root , k);
        return result;
    }
}


// class Solution {
//     public int kthSmallest(TreeNode root, int k) {
//         TreeMap<Integer , Integer> map = new TreeMap<>();

//         Queue<TreeNode> q = new ArrayDeque<>();

//         q.offer(root);

//         while(!q.isEmpty()){
//             int size = q.size();

//             for(int i = 0; i < size; i++){
//                 TreeNode curr = q.poll();

//                 map.put(curr.val , map.getOrDefault(curr.val , 0) + 1);

//                 if(curr.left != null) q.offer(curr.left);
//                 if(curr.right != null) q.offer(curr.right);
//             }
//         }

//         for(int n : map.keySet()){
//             if(map.get(n) >= k) return n;
            
//             k -= map.get(n);
//         }

//         return -1;
//     }
// }
