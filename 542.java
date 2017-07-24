public class Solution {
	public int check(int x, int y, int[][] matrix){
		int m = matrix.length;
    	int n = matrix[0].length;
    	int[][] dir = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    	int ans = Integer.MAX_VALUE;
    	int a = 0;
    	int b = 0;
    	for(int i = 0; i < 4; i++){
    		a = x + dir[i][0];
    		b = y + dir[i][1];
    		if(a >= 0 && a < m && b >=0 && b < n){
    			if(matrix[a][b] != -1)
    				ans = Math.min(matrix[a][b] + 1, ans);
    		}
    	}
    	if(ans == Integer.MAX_VALUE)
    		return -1;
    	else 
    		return ans;
	}
    public int[][] updateMatrix(int[][] matrix) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int [][] ans = new int[m][n];
    	int positionLeft = 0;
    	for(int i = 0; i < m; i++)
    		for(int j = 0; j < n; j++){
    			if(matrix[i][j] == 0)
    				ans[i][j] = 0;
    			else {
    				ans[i][j] = -1;
    				positionLeft++;
    			}
    		}
    	int k = 1;
    	while(positionLeft > 0){
			for(int i = 0; i < m; i++){
    			for(int j = 0; j < n; j++){
					if(ans[i][j] == -1){
					    if(check(i, j, ans) == k){
						    ans[i][j] = k;
						    positionLeft--;
					    }
					}	
				}
    		}
    		k++;
    	}
        return ans;
    }
}