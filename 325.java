public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
	    int len = nums.length; 
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    int ans = 0;
	    int sum = 0;
	    for(int i = 0; i < len; i++){
		    sum += nums[i];
		    if (sum == k)
			    ans = i + 1;
		    else if (map.containsKey(sum - k))
			    ans = Math.max(ans , i - map.get(sum - k));
		    if(!map.containsKey(sum))
			    map.put(sum, i);
	    }
	    return ans;
    }
}