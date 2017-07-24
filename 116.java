/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
	
    public int level = 0;
    
    public void DFS(TreeLinkNode c, TreeLinkNode[] arr){
        if(arr[level] != null)
            arr[level].next = c;
        arr[level] = c;
        level++;
        if(c.left != null){
            DFS(c.left, arr);
            DFS(c.right,arr);
        }
        level--;
    }

    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        int lev = 0;
        TreeLinkNode temp = root;
        while(temp.left != null){
            temp = temp.left;
            lev++;
        }
        TreeLinkNode[] arr = new TreeLinkNode[lev+1];
        if(lev > 0)
            DFS(root, arr);
        root.next = null;
    }
}