// 363. Max Sum of Rectangle No Larger Than K

1   2  3  4  5
6   7  8  9 10
-1 -2 -3 -4 -5

k = 28
binary
m-by-n
m2 n2 = O(m^2 n^2)

// First step: what if it is an 1-D array?
1 2 3 4 5   O(n log n)
1 3 6 10 15
8 []

// Second step: TreeSet
 This implementation provides guaranteed log(n) time cost for the basic operations (add, remove and contains).
3 5 7 4 2 1
1 2 3 4 5 7

   1    [5]
   2    [6]
m  3    [7]

   i-------------
   [     18        ]
         n
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < m; i++){
            int[] arr = new int[n];
            for(int j = i; j >=0; j--){
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                for(int p = 0; p < n; p++){
                    arr[p] += matrix[j][p];
                    val += arr[p];
                    Integer subres = set.ceiling(val-k);
                    if(subres != null){
                        res = Math.max(res, val-subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;
    }
}
