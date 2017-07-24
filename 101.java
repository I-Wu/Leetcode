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

	public List<Integer> mylist = new ArrayList<Integer>();
    public List<Integer> levellist = new ArrayList<Integer>();

	public int level = 0;

	public boolean check(List<Integer> l){
		int left = 0;
		int right = l.size() -1;
		while(left < right){
			if(l.get(left) != l.get(right))
				return false;
			left++;
			right--;
		}
		return true;
	}

	public void DFS(TreeNode root){
		if(root == null)
			return;
		level++;
		DFS(root.left);
		mylist.add(root.val);
		levellist.add(level);
		DFS(root.right);
		level--;
	}
    public boolean isSymmetric(TreeNode root) {
    	DFS(root);
    	return check(mylist) && check(levellist);    
    }
}