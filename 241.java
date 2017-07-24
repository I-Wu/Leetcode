public class Solution {
    public List<Integer> helperplus(List<Integer> first, List<Integer> second){
        List<Integer> ans = new ArrayList<Integer>();
        int a = first.size();
        int b = second.size();
        int new_element = 0;
        for(int i = 0; i < a; i++){
            int target = first.get(i);
            for(int j = 0; j < b; j++){
                new_element = target + second.get(j);
                //if(!ans.contains(new_element))
                    ans.add(new_element);
            }
        }
        return ans;
    }
    
    public List<Integer> helperminus(List<Integer> first, List<Integer> second){
        List<Integer> ans = new ArrayList<Integer>();
        int a = first.size();
        int b = second.size();
        int new_element = 0;
        for(int i = 0; i < a; i++){
            int target = first.get(i);
            for(int j = 0; j < b; j++){
                new_element = target - second.get(j);
                //if(!ans.contains(new_element))
                    ans.add(new_element);
            }
        }
        return ans;
    }
    
    public List<Integer> helpermulti(List<Integer> first, List<Integer> second){
        List<Integer> ans = new ArrayList<Integer>();
        int a = first.size();
        int b = second.size();
        int new_element = 0;
        for(int i = 0; i < a; i++){
            int target = first.get(i);
            for(int j = 0; j < b; j++){
                new_element = target * second.get(j);
                //if(!ans.contains(new_element))
                    ans.add(new_element);
            }
        }
        return ans;
    }
    
    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        List<Integer> newList = new ArrayList<Integer>();
        boolean flag = false;
        for (int i = 0; i < len; i++){
            if (input.charAt(i) == '+'){
                newList.addAll(helperplus(diffWaysToCompute(input.substring(0,i)), 
                                          diffWaysToCompute(input.substring(i+1,len))));
                flag = true;
            }
            else if (input.charAt(i) == '-'){
                newList.addAll(helperminus(diffWaysToCompute(input.substring(0,i)), 
                                            diffWaysToCompute(input.substring(i+1,len))));
                flag = true;
            } else if (input.charAt(i) == '*'){
                newList.addAll(helpermulti(diffWaysToCompute(input.substring(0,i)), 
                               diffWaysToCompute(input.substring(i+1,len))));
                flag = true;
            }
        }
        if(!flag)
            newList.add(Integer.parseInt(input));
        return newList;
    }
}