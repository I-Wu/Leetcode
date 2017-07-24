public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] pos = new int[l1 + l2]; 
        for (int i = l1-1; i >= 0; i--)
            for (int j = l2-1; j >= 0; j--){
                int cur_shift = i + j + 1;
                int prod = (num1.charAt(i) - '0')*(num2.charAt(j) - '0');
                pos[cur_shift] += prod%10;
                pos[cur_shift-1] += prod/10;
            }
        
        for (int i = l1 + l2 - 1; i >= 0; i--){
            if(pos[i] >= 10){
                pos[i-1] += pos[i]/10;
                pos[i] = pos[i]%10;
            }
        }
            
            
        boolean flag = false;
        String ans = "";
        for (int i = 0; i < l1 + l2; i++){
            if(!flag && pos[i] == 0)
                continue;
            else{
                flag = true;
                ans = ans + String.valueOf(pos[i]);
            }
        }
        if(!flag)
            return "0";
        else
            return ans;
    }
}