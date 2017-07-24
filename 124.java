/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int maxValue = Integer.MIN_VALUE;
    public int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        int ans = Math.max(Math.max(l, r), 0) + root.val;
        if (l <= 0)
            maxValue =  Math.max(Math.max(maxValue, r + root.val), root.val);
        else if (r <= 0)
            maxValue =  Math.max(Math.max(maxValue, l + root.val), root.val);
        else
            maxValue = Math.max(maxValue, r + l + root.val);
        //maxValue = Math.max(Math.max(maxValue, l + r + root.val), root.val);
        return ans;
    }
    public int maxPathSum(TreeNode root) {
        helper(root);
        return maxValue;
    }
}