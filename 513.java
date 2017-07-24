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
	int max_level = 0;
    public void DFS(TreeNode root, boolean version, TreeNode[] arr){
    	if(root == null)
    		return;
    	if(version){
	    	if(root.left == null && root.right == null){
    			max_level = Math.max(level, max_level);
	    	}
    	}
    	else{
    	    if(arr[level] == null)
    			arr[level] = root;
    	}
    	level++;
    	DFS(root.left, version, arr);
    	DFS(root.right, version, arr);
    	level--;
    }

    public int findBottomLeftValue(TreeNode root) {
    	TreeNode[] a = new TreeNode[10];
    	DFS(root, true, a);
    	TreeNode[] arr = new TreeNode[max_level+1];
		level = 0;
    	DFS(root, false, arr);
    	return arr[max_level].val;
    }
}