public class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] arr_a = a.split("\\+");
        String[] arr_b = b.split("\\+");
        int realA = Integer.parseInt(arr_a[0]);
        int realB = Integer.parseInt(arr_b[0]);
        int compA = Integer.parseInt(arr_a[1].substring(0, arr_a[1].length()-1));
        int compB = Integer.parseInt(arr_b[1].substring(0, arr_b[1].length()-1));
    	int ans_real = realA * realB - compA * compB;
    	int ans_comp = realA * compB + realB * compA;
    	return String.valueOf(ans_real) + "+" + String.valueOf(ans_comp) + "i";
    }
}