class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>>revadj=new ArrayList<>();
        int []indegree=new int[V];
        ArrayList<Integer>ans=new ArrayList<>();
        Deque<Integer>q=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            revadj.add(new ArrayList<>());
        }
        int n=V;
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            revadj.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            for(int j:revadj.get(i)){
                indegree[j]++;
            }
        }
        
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node=q.peek();
            q.poll();
            ans.add(node);
            for(int i:revadj.get(node)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}