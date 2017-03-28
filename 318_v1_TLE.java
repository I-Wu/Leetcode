// 318 The Skyline Problem

public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        int ans = 0;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++)
                if(nocommon(words[i],words[j]))
                    ans = Math.max(ans, words[i].length() * words[j].length());
        }
        return ans;
    }
    public boolean nocommon(String s1, String s2){
        for(int i = 0; i < s1.length(); i++)
            if(s2.indexOf(s1.charAt(i)) != -1)
                return false;
        return true;
    }
}
