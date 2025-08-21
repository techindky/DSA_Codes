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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1); // empty path prefix
        return dfs(root, 0L, targetSum, prefix);
    }

    private int dfs(TreeNode node, long curr, int target, Map<Long, Integer> prefix) {
        if (node == null) return 0;

        curr += node.val;

        // count paths ending at this node with sum == target
        int res = prefix.getOrDefault(curr - target, 0);

        // add current prefix
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);

        // explore children
        res += dfs(node.left, curr, target, prefix);
        res += dfs(node.right, curr, target, prefix);

        // backtrack: remove current prefix before returning to parent
        prefix.put(curr, prefix.get(curr) - 1);
        if (prefix.get(curr) == 0) prefix.remove(curr);

        return res;
    }
}
