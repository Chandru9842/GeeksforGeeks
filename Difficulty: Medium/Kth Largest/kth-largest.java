class Solution {
    public static int kthLargest(int arr[], int k) {
        PriorityQueue<Integer>q=new PriorityQueue<>();
        for(int i:arr){
            q.add(i);
        }
        while(q.size()>k){
            q.poll();
        }
        return q.peek();
        
    }
}