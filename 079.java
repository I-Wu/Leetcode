/* Key:
1. just as small island
2. bit wise XOR
*/


public class Solution {
    public boolean helper(char[][] board, int x, int y, char[] word, int i){
        if (i == word.length)
            return true;
        if (x < 0 || y < 0 || x == board.length || y == board[0].length)
            return false;
        if (board[x][y] != word[i]) return false;
        board[x][y]^=256;
        boolean exist = helper(board, x-1, y, word, i+1)
                     || helper(board, x+1, y, word, i+1)
                     || helper(board, x, y+1, word, i+1)
                     || helper(board, x, y-1, word, i+1);
        board[x][y]^=256;
        return exist;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] w = word.toCharArray();
        for(int x = 0; x < m; x++)
            for(int y = 0; y < n; y++)
                if(helper(board, x, y, w, 0))
                    return true;
        return false;
    }
}
