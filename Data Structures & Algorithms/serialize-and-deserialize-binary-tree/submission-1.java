/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();

        if(root == null) return str.toString();

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while(!stack.isEmpty()){

            TreeNode curr = stack.pop();

            if(curr == null) str.append("^");
            else{
                str.append(curr.val);
                    
                stack.push(curr.right);
                stack.push(curr.left);
            }
            str.append(",");
        }

        return str.toString();
    }

    // Decodes your encoded data to tree.

    int idx;

    TreeNode buildTree(String data){
        if(idx >= data.length() || data.charAt(idx) == '^'){
            idx += 2;
            return null;
        }

        StringBuilder str = new StringBuilder();
        while(data.charAt(idx) != ','){
            str.append(data.charAt(idx++));
        }
        idx++;

        int value = Integer.parseInt(str.toString());

        TreeNode root = new TreeNode(value);

        root.left = buildTree(data);
        root.right = buildTree(data);

        return root;
    }

    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;

        idx = 0;
        return buildTree(data);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));