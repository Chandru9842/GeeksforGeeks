class Solution {
    boolean dfs(int start,int col, ArrayList<ArrayList<Integer>>adj,int[][]edges,int[]color){
        color[start]=col;
        for(int it:adj.get(start)){
            if(color[it]==-1){
                 if(dfs(it,1-col,adj,edges,color)==false){
                    return false;
                }
                
            }
            else if(col==color[it]){
                return false;
            }
        }
        return true;
        
    }
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){

    int u = edges[i][0];
    int v = edges[i][1];

    adj.get(u).add(v);
    adj.get(v).add(u);
}
        int color[]=new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                if(dfs(i,0,adj,edges,color)==false){
                    return false;
                }
                
            }

        }
        return true;
    }
}