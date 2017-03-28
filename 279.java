public class Solution {
    public int num_dp(int n, int[] ans)
    {
        if(n == 1) 
            return 1;
        else if(ans[n] != -1){
            return ans[n];    
        }
        else{
            int r = (int)Math.sqrt((double)n);
            int temp = n;
            for (int i = 1; i <= r; i++){
                int temp2 = num_dp(n-i*i,ans)+1;
                if (temp2 < temp) temp = temp2;                
            }
            ans[n] = temp;
            return temp; 
        }
    }
    public int numSquares(int n) {
        int [] ans = new int [n+1];
        for(int i = 1; i < n+1; i++)
            ans[i] = -1;
        return num_dp(n,ans);
    }
}