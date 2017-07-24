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
	int level = 0;
    List<Integer> ans = new ArrayList<Integer>();

    public void DFS(TreeNode root) {
    	if(root == null)
    	    return;
    	if(level >= ans.size()){
    		ans.add(root.val);
    	}
    	else
    		ans.set(level, Math.max(ans.get(level), root.val));
    	
    	level++;
    	DFS(root.left);
    	DFS(root.right);
    	level--;
    }

    public List<Integer> largestValues(TreeNode root) {
    	DFS(root);    
    	return ans;
    }
}