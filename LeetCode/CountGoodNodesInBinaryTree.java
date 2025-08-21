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
    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxTillNow) {
        if (node == null) return 0;
        int good = 0;
        if (node.val >= maxTillNow) {
            good = 1;
            maxTillNow = node.val;
        }
        return good + dfs(node.left, maxTillNow) + dfs(node.right, maxTillNow);
    }
}
