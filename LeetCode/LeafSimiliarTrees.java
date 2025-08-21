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
    private int nextLeaf(Deque<TreeNode> queue) {
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (node.left == null && node.right == null) return node.val;
            if (node.right != null) queue.push(node.right);
            if (node.left != null) queue.push(node.left);
        }
        return -1;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> q1 = new ArrayDeque<>();
        Deque<TreeNode> q2 = new ArrayDeque<>();
        if (root1 != null) q1.push(root1);
        if (root2 != null) q2.push(root2);
        while(true) {
            int a = nextLeaf(q1);
            int b = nextLeaf(q2);
            if (a == -1 || b == -1) return a == b;
            if (a != b) return false;
        }
    }
}
