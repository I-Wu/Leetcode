public class Solution {
    
    public boolean helper(int[] a, int s, int e){
        if(s >= e)
            return true;
        int pivot = a[s];
        int bigger = -1;
        for(int i = s+1; i <= e; i++){
            if(bigger == -1 && a[i] > pivot)
                bigger = i;
            if(bigger != -1 && a[i] < pivot)
                return false;
        }   
        if(bigger == -1)
            return helper(a, s+1, e);
        else
            return helper(a, s+1, bigger - 1) && helper(a, bigger, e); 
    }
    
    public boolean verifyPreorder(int[] preorder) {
        if(preorder.length == 0)
            return true;
        else
            return helper(preorder, 0, preorder.length - 1);
    }
}