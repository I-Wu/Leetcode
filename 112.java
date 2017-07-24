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
    public boolean helper(TreeNode r, int s){
        if (r.left == null && r.right == null){
            if(s-r.val == 0)
                return true;
            else 
                return false;
        }
        else if (r.left == null && r.right != null)
            return helper(r.right, s-r.val);
        else if (r.left != null && r.right == null)
            return helper(r.left, s-r.val);
        else
            return helper(r.left, s-r.val) || helper(r.right, s-r.val);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return helper(root, sum);
    }
}