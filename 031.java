public class Solution {
    public void change(int[] nums, int m, int n){
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
        return;
    }

    public void push_to_next_digit(int[] nums, int ind){
        int n = nums.length;
        int i = n-1;
        while(true){
            if(nums[ind-1] < nums[i]){
                change(nums, ind-1, i);
                break;
            }
            i--;
        }
        reverse(nums, ind, nums.length-1);
        return;
    }

    public void reverse(int[] nums, int left, int right){
        while(left < right){
            change(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return;
        int i = n-1;
        while(i > 0){
            if(nums[i] > nums[i-1]){
                push_to_next_digit(nums, i);
                break;
            }
            i--;
        }
        if(i == 0){// switch the all array
            reverse(nums, 0, n-1);
        }
    }
}
