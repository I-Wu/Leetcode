public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new ArrayList<int[]>();
        if(nums1.length == 0||nums2.length == 0)
            return ans;
        PriorityQueue<int[]> myQ = new PriorityQueue<int[]>(1, new Comparator<int[]>(){
            public int compare(int[] tup_a, int[] tup_b){
                int sum_a = tup_a[0] + tup_a[1];
                int sum_b = tup_b[0] + tup_b[1];
                if(sum_a > sum_b)
                    return 1;
                else if(sum_a == sum_b)
                    return 0;
                else
                    return -1;
            }
        });
        for (int i = 0; i < nums1.length; i++){
            myQ.offer(new int[]{nums1[i], nums2[0], 0});
        }
        int count = 0;
        while(count < k && myQ.peek()!= null){
            int[] x = myQ.poll();
            ans.add(new int[]{x[0], x[1]});
            if (x[2]+1 < nums2.length) {
                myQ.offer(new int[]{x[0], nums2[x[2]+1], x[2]+1});
            }
            count++;
        }
        return ans;
    }
}

