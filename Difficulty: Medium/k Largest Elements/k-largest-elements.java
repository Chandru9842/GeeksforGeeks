class Solution {
    public ArrayList<Integer> kLargest(int[] arr, int k) {
        ArrayList<Integer>ans=new ArrayList<>();
        
        PriorityQueue<Integer>q=new PriorityQueue<>();
        for(int i:arr){
            q.add(i);
            if(q.size()>k){
                q.poll();
            }
            
        }
        while(!q.isEmpty()){
            ans.add(q.poll());
        }
        Collections.sort(ans,Collections.reverseOrder());
        return ans;
        
    }
}
