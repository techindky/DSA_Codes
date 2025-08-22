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
import java.util.*;

class Solution {
    private Map<Integer, Integer> idx; // value -> inorder index
    private int prePos;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        idx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) idx.put(inorder[i], i);
        prePos = 0;
        return build(preorder, 0, inorder.length - 1);
    }

    // Build tree from inorder[l..r]
    private TreeNode build(int[] preorder, int l, int r) {
        if (l > r) return null;
        int val = preorder[prePos++];          // root value from preorder
        TreeNode root = new TreeNode(val);
        int mid = idx.get(val);                // split inorder
        root.left = build(preorder, l, mid - 1);
        root.right = build(preorder, mid + 1, r);
        return root;
    }
}
