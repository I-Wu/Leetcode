public class Solution {
    
    public List<List<Integer>> helper(int[] nums, int len){
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(len == 0){
            List<Integer> first = new ArrayList<Integer>();
            //first.add(nums[0]);
            ans.add(first);
        }
        else{
            List<List<Integer>> pre = helper(nums, len-1);
            for(int i = 0; i < pre.size(); i++){
                List<Integer> cur = ((List) ((ArrayList) pre.get(i)).clone());; // clone list
                ans.add(pre.get(i));
                cur.add(nums[len-1]);
                ans.add(cur);
            }
        }
        return ans;
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        return /*List<List<Integer>> myList = */ helper(nums, nums.length);
    }
}