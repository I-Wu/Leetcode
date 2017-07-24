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
    public String temp = "";
    public int sum = 0;
    public int position = 0;
    public String replaceAt(String s, int pos, int i) {
        char c = (char) (i + '0');
        return s.substring(0, pos) + c + s.substring(pos + 1);
    }
    
    public int DFS(TreeNode root){
        if (root == null)
            return 0;
        if (position == temp.length())
            temp += String.valueOf(root.val);
        else
            temp = replaceAt(temp, position, root.val);
        position++;
        if (root.left == null && root.right == null){
            sum += Integer.parseInt(temp.substring(0, position));
        }
        else{ 
            DFS(root.left);
            DFS(root.right);
        }
        position--;
        return sum;
    }
    public int sumNumbers(TreeNode root) {
        return DFS(root);
    }
}