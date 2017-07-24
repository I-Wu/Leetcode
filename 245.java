public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int len = words.length;
        int ans = len;
        int first = 0;
        int second = 0;
        if(word1.equals(word2)){
            first = -1;
            second = 0;
            for(int i = 0; i < len; i++){
                if(words[i].equals(word2)){
                    second = i;
                    break;
                }
            }
            for(int i = second + 1; i < len; i++){
                if(words[i].equals(word2)){
                    first = second;
                    second = i;
                    ans = Math.min(ans, second-first);
                }
            }
        }
        else{
            int update = 0;
            for(int i = 0; i < len; i++){
                if(words[i].equals(word1)){
                    if(update == 2)
                        ans = Math.min(ans, i-second);
                    first = i;
                    update = 1;
                }
                if(words[i].equals(word2)){
                    if(update == 1)
                        ans = Math.min(ans, i-first);
                    second = i;
                    update = 2;
                }
            }
        }
        return ans;
    }
}