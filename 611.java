public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int cnt = 0;
        for(int i = 0; i < len-2; i++){
            for(int j = i+1; j < len-1; j++){
                for(int k = len-1; k > j; k--){
                    if(nums[i] + nums[j] > nums[k]){
                        cnt += k - j;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}