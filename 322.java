public class Solution {
    public int helper(int[] c, int amount, int[] dp){
        int min = Integer.MAX_VALUE;
        if(amount < 0)
            return Integer.MAX_VALUE;
        if(dp[amount]!= -1)
            return dp[amount];
        else{
            for(int i: c){
                if(helper(c, amount-i, dp)!= Integer.MAX_VALUE)
                    min = Math.min(min, helper(c, amount-i, dp) + 1);
            }
        }
        dp[amount] = min;
        return min;
    }
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int[] dp = new int[amount+1];
        for(int i = 0; i <= amount; i++)
            dp[i] = -1;
        dp[0] = 0;
        if(helper(coins, amount, dp) == Integer.MAX_VALUE)
            return -1;
        else
            return helper(coins, amount, dp);
    }
}