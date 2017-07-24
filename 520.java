public class Solution {
    public boolean isAllUpper(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < 'A' || s.charAt(i) > 'Z')
                return false;
        }
        return true;
    }
    public boolean isAllLower(String s){
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) < 'a' || s.charAt(i) > 'z')
                return false;
        }
        return true;
    }
    
    
    
    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if(len == 1)
            return true;
        else{
            if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') // upper case
            {
                return isAllLower(word.substring(1)) || isAllUpper(word.substring(1));                
            }
            else{
                return isAllLower(word.substring(1));
            }
            
            
        }
        
    }
}