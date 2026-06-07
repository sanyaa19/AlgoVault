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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //since it's a binary tree
        //if p & q < root we will check towards left fro lca node
        //if p & q > root we will check towards right fro lca node
        //but if both are from opposite side then root is the lca node

        while(root != null){
            if(p.val < root.val && q.val < root.val) root= root.left;

            else if(p.val > root.val && q.val > root.val) root= root.right;

            else return root;
        }

        return null;
    }
}

//class Solution {
//     ArrayList<TreeNode> pathToDest;
//     public void findPath(TreeNode root , TreeNode dest , ArrayList<TreeNode> list){
//         if(root == null) return;

//         list.add(root);

//         if(root.val == dest.val){
//             pathToDest = new ArrayList<>(list);
//             return;
//         }
//         else{
//             if(root.left != null) findPath(root.left , dest , list);
//             if(root.right != null) findPath(root.right , dest , list);            
//         }

//         list.remove(list.size() - 1);
//         return;
//     }
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         findPath(root , p , new ArrayList<>());
//         ArrayList<TreeNode> Path1 = new ArrayList<>(pathToDest);

//         pathToDest = null;

//         findPath(root , q , new ArrayList<>());
//         ArrayList<TreeNode> Path2 = new ArrayList<>(pathToDest);

//         HashSet<TreeNode> set = new HashSet<>();

//         for(int i = 0; i < Path1.size(); i++){
//             set.add(Path1.get(i));
//         }

//         for(int i = Path2.size() - 1; i >= 0; i--){
//             if(set.contains(Path2.get(i))) return Path2.get(i);
//         }

//         return null;
//     }
// }

