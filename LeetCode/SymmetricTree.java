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
 //Approach 1 : Recursively
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }
    private boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null || b == null) return a == b;
        if (a.val != b.val) return false;
        return isMirror(a.left, b.right) && isMirror(a.right, b.left);
    }
}

/* Approach 2 : Iterative
import java.util.*;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode a = q.poll();
            TreeNode b = q.poll();
            if (a == null && b == null) continue;
            if (a == null || b == null || a.val != b.val) return false;
            // Enqueue mirror pairs
            q.add(a.left);  q.add(b.right);
            q.add(a.right); q.add(b.left);
        }
        return true;
    }
}
*/
