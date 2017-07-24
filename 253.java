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
    public int minMeetingRooms(Interval[] intervals) {

        PriorityQueue<int[]> myQ = new PriorityQueue<int[]>(10, (a,b) -> a[0]-b[0]);
        int len = intervals.length;
        for(int i = 0; i < len; i++){
        	myQ.offer(new int[]{intervals[i].start, 1});
        	myQ.offer(new int[]{intervals[i].end, -1});
        }
        int cur_time = 0;
        int cur_capacity = 0;
        int max_capacity = 0;
        while(myQ.size()!= 0){
        	int[] stamp = myQ.poll();
        	if(stamp[0] == cur_time){
        		cur_capacity += stamp[1];
        	}
        	else{
        		max_capacity = Math.max(cur_capacity, max_capacity);
        		cur_time = stamp[0];
        		cur_capacity += stamp[1];
        	}
        }
        return max_capacity;
    }
}