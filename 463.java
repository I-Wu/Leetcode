public class Solution {
    public int islandPerimeter(int[][] grid) {
        int l = grid.length;
        int w = grid[0].length;
        int[][] helper = new int[l+2][w+2];
        for(int i = 0; i <= l+1; i++)
            for(int j = 0; j <= w+1; j++)
                if((i == 0) || (i == l+1) || (j == 0) || (j == w+1))
                    helper[i][j] = 0;
                else
                    helper[i][j] = grid[i-1][j-1];
        int count = 0;
        for(int i = 0; i <= l; i++)
            for(int j = 0; j <= w; j++){
                if(helper[i][j] != helper[i+1][j])
                    count++;
                if(helper[i][j] != helper[i][j+1])
                    count++;
            }
        return count;
    }
}