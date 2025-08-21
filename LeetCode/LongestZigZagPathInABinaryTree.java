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
 *         this.right = right;
 *         this.left = left;
 *     }
 * }
 */
class Solution {
    private int ans = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        // Start from root, try both initial directions
        dfs(root.left, 1, true);   // we just moved left from root; next should go right
        dfs(root.right, 1, false); // we just moved right from root; next should go left
        return ans;
    }

    // node: current node
    // length: current ZigZag length so far (edges count)
    // lastMoveWasLeft: whether the last edge taken was to the left child
    private void dfs(TreeNode node, int length, boolean lastMoveWasLeft) {
        if (node == null) return;

        ans = Math.max(ans, length);

        if (lastMoveWasLeft) {
            // Last move was left, so to continue ZigZag we must go right.
            // Continue ZigZag by going right (length+1)
            dfs(node.right, length + 1, false);
            // If we go left again, we break the ZigZag and restart from length=1
            dfs(node.left, 1, true);
        } else {
            // Last move was right, so to continue ZigZag we must go left.
            dfs(node.left, length + 1, true);
            dfs(node.right, 1, false);
        }
    }
}
