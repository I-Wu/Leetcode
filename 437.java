public class Solution {
	int count = 0;
	public void helper(TreeNode root, int sum){
		if (sum - root.val == 0) {
			count++;
		}
		if (root.left != null)
			helper(root.left, sum - root.val);
		if (root.right != null)
			helper(root.right, sum - root.val);	
	}
	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		if (root.left != null)
			pathSum(root.left, sum);
		if (root.right != null)
			pathSum(root.right, sum);
		helper(root, sum);
		return count;
    }
}