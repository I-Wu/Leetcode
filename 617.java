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
	public TreeNode helper(TreeNode t1, TreeNode t2) {
		if(t2 == null)
			return t1;
		else if(t1 == null)
			return t2;
		else{
			t1.val += t2.val;
			t1.left = helper(t1.left, t2.left);
			t1.right = helper(t1.right, t2.right);
			return t1;
		}
	}


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return helper(t1, t2);
    }
}