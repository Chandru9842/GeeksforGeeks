class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        // List<Integer>ans=new ArrayList<>();
        // // int stock=1;
        // for(int i=0;i<=arr.length-1;i++){
        //     int j=i-1;
        //     int stock=1;
        //     while(j>=0&&arr[j]<=arr[i]){
        //         stock++;
        //         j--;
        //     }
        //     ans.add(stock);
        //     // Collections.reverse(ans);
        // }
        // return new ArrayList<>(ans);
        
        
        List<Integer>ans=new ArrayList<>();
        Deque<Integer>st=new ArrayDeque<>();
        int ind=0;
        for(int i=0;i<arr.length;i++){
            
            while(!st.isEmpty()&&arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans.add(i+1);
            }
            if(!st.isEmpty()&&arr[st.peek()]>=arr[i]){
                ans.add(i-st.peek());
            }
            // else{
            //     st.push(i);
            // }
            st.push(i);
        }
        return new ArrayList<>(ans);
        
    }
}