/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> input){
        int len = input.size();
        if (len == 1)
            return input;
        List<Interval> ans = new ArrayList<Interval>();
        boolean flag = true;
        for(int i = 0; i < len-1; i++){
            if(input.get(i).end == input.get(i+1).start){
                ans.add(new Interval(input.get(i).start,input.get(i+1).end));
                if(i == len-2){
                    flag = false;
                }
                i++;
            }
            else
                ans.add(input.get(i));
        }
        if(flag)
            ans.add(input.get(len-1));
        return ans;
    }


    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList<Interval>();
        int len = intervals.size();
        if(len == 0){
            ans.add(newInterval);
            return ans;
        }
        int a = newInterval.start;
        int b = newInterval.end;
        boolean inside_any = false;
        Interval temp = new Interval(a, b);
        for(int i = 0; i < len; i++){
            a = temp.start;
            b = temp.end;
            int c = intervals.get(i).start;
            int d = intervals.get(i).end;
            if(inside_any)
                ans.add(new Interval(c,d));
            else{ // cadb
                if(c > b){ //  a b c d
                    ans.add(temp);
                    ans.add(new Interval(c,d));
                    inside_any = true;
                }
                else if (b < d){ // cabd acbd
                    ans.add(new Interval(Math.min(a,c), d));
                    inside_any = true;
                }
                else if(d > a){ // cadb acdb
                    temp.start = d;
                    temp.end = b;
                    ans.add(new Interval(Math.min(a,c), d));
                }
                else if(d < a){
                    ans.add(new Interval(c,d));
                    continue;
                }
                else{ // d == a
                    temp.start = c;
                    temp.end = b;
                }
            }
        }
        if(!inside_any){
            if(ans.size() == 0)
                ans.add(temp);
            else{
                Interval last = ans.get(ans.size()-1);
                if(last.end == temp.start){
                    ans.remove(ans.size()-1);
                    ans.add(new Interval(last.start, temp.end));
                }
                else
                    ans.add(temp);
            }
        }
        List<Interval> next = merge(ans);
        while(next.size()!= ans.size()){
            ans = next;
            next = merge(next);
        }
        return next;
    }
}
