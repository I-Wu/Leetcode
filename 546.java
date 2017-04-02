public class Solution {
    
    public int get(int[][][] dp, int[] boxes, int i, int j, int k){
        if(i > j)
            return 0;
        else if(i == j)
            return k * k;
        else if(dp[i][j][k]!= 0)
            return dp[i][j][k];
        else{
            int temp = get(dp, boxes, i+1, j, 1) + k*k;
            //System.out.println(temp);
            for(int m = i+1; m <= j; m++)
                if(boxes[m] == boxes[i])
                    temp = Math.max(temp, get(dp, boxes, i+1, m-1, 1) + get(dp, boxes, m, j, k+1));
            dp[i][j][k] = temp;
            return temp;
        }
    }
    
    public int removeBoxes(int[] boxes) {
        if(boxes == null || boxes.length == 0)
            return 0;
        int size = boxes.length;
        int [][][] dp = new int[size][size][size];
        return get(dp, boxes, 0, size-1, 1);
    }
}