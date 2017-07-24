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
	public TreeNode helper(int[] nums, int start, int end) {
		if(end < start)
			return null;
		else if(end == start)
		    return new TreeNode(nums[start]);
		int index = (start + end + 1)/2;
		TreeNode root = new TreeNode(nums[index]);
		TreeNode l = helper(nums, start, index -1);
		TreeNode r = helper(nums, index+1, end);
		root.left = l;
		root.right = r;
		return root;
	}
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
}