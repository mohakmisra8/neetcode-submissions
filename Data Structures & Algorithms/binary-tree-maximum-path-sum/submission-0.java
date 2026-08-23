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
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gain(root);
        return maxSum;
    }

    private int gain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // best downard gain from each child: cla,p negatives to 0 (skip)
        int leftGain = Math.max(gain(node.left), 0);
        int rightGain = Math.max(gain(node.right), 0);

        // path bends at this node, using both sides
        int bendSum = node.val +leftGain+rightGain;
        maxSum = Math.max(bendSum, maxSum);

        // but to the parent, we can only offer one side+this node
        return node.val + Math.max(leftGain, rightGain);
    }
}
