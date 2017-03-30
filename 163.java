public class Solution {
    public String generateString(int start, int end){
        if(start == end)
            return String.valueOf(start);
        else{
         return    
            String.valueOf(start) + "->" + String.valueOf(end);
        }
    }
    
    
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<String>();
        int len = nums.length;
        if(len == 0){
            ans.add(generateString(lower, upper));
            return ans;
        }
        if(lower < nums[0])
            ans.add(generateString(lower, nums[0]-1));
        for(int i = 0; i < len-1; i++){
            if(nums[i+1] - nums[i] > 1 || (nums[i+1] == 2147483647 && nums[i] != 2147483647) 
                                       || (nums[i] == -2147483648 && nums[i+1] != -2147483648))    
                ans.add(generateString(nums[i]+1, nums[i+1]-1));
        }
        if(upper > nums[len-1])
            ans.add(generateString(nums[len-1]+1, upper));
        return ans;
    }
}