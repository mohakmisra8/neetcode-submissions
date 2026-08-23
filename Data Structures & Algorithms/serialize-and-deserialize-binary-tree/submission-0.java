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

public class Codec {
    // pre-order dfs

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialiseHelper(root, sb);
        return sb.toString();
        
    }

    private void serialiseHelper(TreeNode root, StringBuilder sb) {
        if(root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");
        serialiseHelper(root.left, sb);
        serialiseHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialiseHelper(nodes);
        
    }

    private TreeNode deserialiseHelper(Queue<String> nodes) {
        String val = nodes.poll();
        if(val.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserialiseHelper(nodes);
        node.right = deserialiseHelper(nodes);
        return node;
    }
}
