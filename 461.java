public class Solution {
    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int cnt = 0;
        while(a > 0){
            cnt += a & 1;
            a/= 2;
        }
        return cnt;
    }
}