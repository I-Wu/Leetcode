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
	String mystring = "";

	List<String> mylist = new ArrayList<String>();
        
	public void DFS(TreeNode root){
		mystring = mystring + "->" + String.valueOf(root.val);
		int len = mystring.length();
		if(root.left == null){
			if(root.right == null)
				mylist.add(mystring.substring(2));
			else{
				DFS(root.right);
				mystring = mystring.substring(0, len);
			}
		}else{
			if(root.right == null){
				DFS(root.left);
				mystring = mystring.substring(0, len);
			}
			else{
				DFS(root.right);
				mystring = mystring.substring(0, len);
				DFS(root.left);
				mystring = mystring.substring(0, len);
			}
		}
	}
  
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)
        	return mylist;
        else{
        	//mystring = mystring + String.valueOf(root.val);
        	DFS(root);
        }
        return mylist;

    }
}