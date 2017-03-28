public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        if(digits == null)
            return ans;
        else if(digits.length() == 0){
            return ans;
        }
        List<String> prev = letterCombinations(digits.substring(1));
        int temp = digits.charAt(0) - '0';
        if(temp == 2){
            if(digits.length() == 1){
                ans.add("a"); ans.add("b"); ans.add("c");
            }
            for(int i = 0; i < prev.size(); i++){
                ans.add("a" + prev.get(i));
                ans.add("b" + prev.get(i));
                ans.add("c" + prev.get(i));
            }
        }
        else if(temp == 3){
             if(digits.length() == 1){
                ans.add("d"); ans.add("e"); ans.add("f");
            }
            for(int i = 0; i < prev.size(); i++){
                ans.add("d" + prev.get(i));
                ans.add("e" + prev.get(i));
                ans.add("f" + prev.get(i));
            }
        }
        else if(temp == 4){
             if(digits.length() == 1){
                ans.add("g"); ans.add("h"); ans.add("i");
            }
            for(int i = 0; i < prev.size(); i++){
                ans.add("g" + prev.get(i));
                ans.add("h" + prev.get(i));
                ans.add("i" + prev.get(i));
            }
        }
        else if(temp == 5){
            if(digits.length() == 1){
                ans.add("j"); ans.add("k"); ans.add("l");
            }
            for(int i = 0; i < prev.size(); i++){
                ans.add("j" + prev.get(i));
                ans.add("k" + prev.get(i));
                ans.add("l" + prev.get(i));
            }
        }
        else if(temp == 6){
            if(digits.length() == 1){
                ans.add("m"); ans.add("n"); ans.add("o");
            }
            for(int i = 0; i < prev.size(); i++){
                ans.add("m" + prev.get(i));
                ans.add("n" + prev.get(i));
                ans.add("o" + prev.get(i));
            }
        }
        else if(temp == 7){
            if(digits.length() == 1){
                ans.add("p"); ans.add("q"); ans.add("r"); ans.add("s");
            }
            for(int i = 0; i < prev.size(); i++){
                ans.add("p" + prev.get(i));
                ans.add("q" + prev.get(i));
                ans.add("r" + prev.get(i));
                ans.add("s" + prev.get(i));
            }
        }
        else if(temp == 8){
            if(digits.length() == 1){
                ans.add("t"); ans.add("u"); ans.add("v");
            }
            for(int i = 0; i < prev.size(); i++){
                ans.add("t" + prev.get(i));
                ans.add("u" + prev.get(i));
                ans.add("v" + prev.get(i));
            }
        }
        else if(temp == 9){
            if(digits.length() == 1){
                ans.add("w"); ans.add("x"); ans.add("y"); ans.add("z");
            }
            for(int i = 0; i < prev.size(); i++){
                ans.add("w" + prev.get(i));
                ans.add("x" + prev.get(i));
                ans.add("y" + prev.get(i));
                ans.add("z" + prev.get(i));
            }
        }
        return ans;
    }

}
