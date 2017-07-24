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
    HashMap<Integer, Integer> mymap = new HashMap<Integer, Integer>();
    int max = 1;
    
    public List<Integer> getKeyFromValue(HashMap<Integer, Integer> hm, Integer value) {
        List<Integer> myList = new ArrayList<Integer>();
        for (Integer o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                 myList.add(o);
            }
        }
        return myList;
    }
    
    public int DFS(TreeNode root){
        if(root == null)
            return 0;
        else{
            int ans = DFS(root.left) + DFS(root.right) + root.val;
            if(mymap.containsKey(ans)){
                int NewVal = mymap.get(ans)+1;
                max = Math.max(max, NewVal);
                mymap.put(ans, NewVal);
            }
            else{
                mymap.put(ans, 1);
            }
            return ans;
        }
    }
    
    public int[] findFrequentTreeSum(TreeNode root) {
        DFS(root);
        List<Integer> ans = getKeyFromValue(mymap, max);
        int[] a = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            a[i] = ans.get(i);
        }
        return a;
    }
}