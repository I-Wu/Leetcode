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
    public TreeNode str2tree(String s) {
        if(s.length() == 0)
            return null;
        TreeNode t = new TreeNode(0);
        int startL = s.indexOf('(');
        if(startL == -1){
        	t.val = Integer.parseInt(s);
        	t.left = null;
        	t.right = null;
        }
        else{
        	int cnt = 0;
        	int endL = 0;
        	for(int i = startL; i < s.length(); i++){
        		if(s.charAt(i) == '(')
        			cnt++;
        		else if(s.charAt(i) == ')')
        			cnt--;
        		if(cnt == 0){
                    endL = i;
        			break;
        		}
        	}
        	TreeNode l = str2tree(s.substring(startL + 1, endL));
        	TreeNode r = new TreeNode(0);
        	if(endL == s.length() - 1)
        	    r = null;
        	else
            	r = str2tree(s.substring(endL + 2, s.length()-1));
        	t.left = l;
        	t.right = r;
        	t.val = Integer.parseInt(s.substring(0, startL));
        }
        return t;
    }
}