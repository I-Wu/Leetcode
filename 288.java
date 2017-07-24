public class ValidWordAbbr {
    public HashMap<String, String> MyMap = new HashMap<String, String>();
    public HashMap<String, Integer> Duplicate = new HashMap<String, Integer>();
    public String abbr(String word){
        int len = word.length();
        if(len <= 2)
            return word;
        String ans = word.substring(0,1) + String.valueOf(len-2) + word.substring(len-1, len);
        System.out.println(ans);
        return ans;
    }
    
    public ValidWordAbbr(String[] dictionary) {
        for(String s:dictionary){
            String temp = abbr(s);
            if(!MyMap.containsKey(temp))
                MyMap.put(temp, s);
            else{
                String ans = MyMap.get(temp);
                if(!ans.equals(s))
                    Duplicate.put(temp, 1);    
            }
        }
    }
    
    public boolean isUnique(String word) {
        String temp = abbr(word);
        if(Duplicate.containsKey(temp))
            return false;
        if(MyMap.get(temp) == null)
            return true;
        String ans = MyMap.get(temp);
        return ans.equals(word);
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */