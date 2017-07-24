public class Solution {
    public boolean checkRecord(String s) {
        boolean cnt_A = false;
        int cur_L = 0;
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) == 'A'){
        		if(cnt_A)
        			return false;
        		else
        			cnt_A = true;
        		cur_L = 0;
        	}
        	else if(s.charAt(i) == 'L'){
        		if(cur_L == 2)
        			return false;
        		else
        			cur_L++;
        	}
        	else
        		cur_L = 0;
        }
        return true;
    }
}