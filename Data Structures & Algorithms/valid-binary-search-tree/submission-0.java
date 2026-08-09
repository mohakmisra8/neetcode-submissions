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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
    }

    public boolean helper(TreeNode node, Integer left, Integer right) {
        if(node == null) {
            return true;
        }

        if(!(left < node.val && node.val < right)) {
            return false;
        }

        return helper(node.left, left, node.val) && helper(node.right, node.val, right);
    }
}
