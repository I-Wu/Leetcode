public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<int[]>();
        List<int[]> height = new ArrayList<int[]>();
        for(int[] h: buildings){
            height.add(new int[]{h[0], -h[2]});
            height.add(new int[]{h[1], h[2]});            
        }
        Collections.sort(height, (a,b) ->{
            if(a[0]!= b[0])
                return a[0]-b[0];
            else
                return a[1]-b[1];   
        });
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b)-> (b-a));
        pq.offer(0);
        int prev = 0;
        for(int[] h: height){
            if(h[1] < 0)
                pq.offer(-h[1]);
            else 
                pq.remove(h[1]);
            int cur = pq.peek();
            if(prev != cur){
                result.add(new int[]{h[0],cur});
                prev = cur;
            }
        }
        return result;
    }
}