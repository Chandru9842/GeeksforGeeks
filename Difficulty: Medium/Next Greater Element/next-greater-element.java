class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        List<Integer>ans=new ArrayList<>();
        Deque<Integer>st=new ArrayDeque<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
           while(!st.isEmpty()&&arr[i]>=st.peek()){
               st.pop();
           }
           if(st.isEmpty()){
               ans.add(-1);
           }
           else{
               ans.add(st.peek());
           }
           st.push(arr[i]);
        }
        Collections.reverse(ans);
        return new ArrayList<>(ans);
        // code here
        
    }
}