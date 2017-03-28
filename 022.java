public class Solution {
    public void Decision(boolean sign, int pos, int current, int count, String s, List<String> ans){
        count --;
        System.out.println(count);
        String next = s;
        if (sign){    
            next = next + "(";
            pos--;
            current++;
        }
        else{
            next = next + ")";
            current--;
        }
        if (count == 0){
            ans.add(s+")");
            return;
        }
        
        if(pos > 0){
            Decision(true, pos, current, count, next, ans); 
        }
        if (current > 0){
            Decision(false, pos, current, count, next, ans);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        int pos = n;
        int current = 0;
        int count = n*2;
        String s = "";
        Decision(true, pos, current, count, s, ans);
            
        return ans;    
    }
}