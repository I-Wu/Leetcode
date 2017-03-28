public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int[] value = new int[len];
        int ans = 0;
        for(int i = 0; i < len; i++)
            for(int j = 0; j < words[i].length(); j++)
                value[i] |= 1 << (words[i].charAt(j) - 'a');
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++)
                if((value[i] & value[j]) == 0)
                    ans = Math.max(ans, words[i].length() * words[j].length());
        }
        return ans;
    }
