class Solution {
    public int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer>q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:arr){
            q.add(i);
        }
        while(q.size()>k){
            q.poll();
        }
        return q.peek();
        
    }
}
