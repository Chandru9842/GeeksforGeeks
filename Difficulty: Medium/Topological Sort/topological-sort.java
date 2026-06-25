class Solution {
     void dfs(int node,int[]vis, ArrayList<ArrayList<Integer>>adj,int[][]edges, Stack<Integer>st){
        vis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                dfs(it,vis,adj,edges,st);
                    // return true;
                
            }
        }
        st.add(node);
        // return false;
    }
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           adj.get(u).add(v);
        }
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,adj,edges,st);
            }
            
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!st.isEmpty()){
    ans.add(st.pop());
}
return ans;
        
    }
}