public class Solution {
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int left = 0;
        int right = len-1;
        if(len == 0)
            return 0;
        int ans = len;
        while(left <= right){
            if(val == nums[left]){
                swap(nums, left, right);                
                right--;
                ans--;
            }
            else
                left++;
        }
        return ans;
    }
}