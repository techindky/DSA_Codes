class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root, null, null);
    }

    private boolean dfs(TreeNode node, Long low, Long high) {
        if (node == null) return true;
        long v = node.val;
        if (low != null && v <= low) return false;
        if (high != null && v >= high) return false;
        return dfs(node.left, low, v) && dfs(node.right, v, high);
    }
}
