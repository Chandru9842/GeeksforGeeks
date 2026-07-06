class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        List<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int[]dist=new int[V];
        Arrays.fill(dist,(int)1e8);
        dist[src]=0;
        for(int i=0;i<V-1;i++){
            for (int u = 0; u < V; u++) { 
            for(Pair it:adj.get(u)){
                // int start=it.first;
                int adjnode=it.first;
                int wt=it.second;
                if(dist[u]!=(int)1e8&&dist[u]+wt<dist[adjnode]){
                    dist[adjnode]=dist[u]+wt;
                    
                }
                
            }
        }
        }
        for(int u=0;u<V;u++){
            for(Pair it:adj.get(u)){
                 int adjNode = it.first;
                  int wt = it.second;
                  if (dist[u] != (int)1e8 &&dist[u] + wt < dist[adjNode]) {

                    return new int[]{-1};
                }
                
            }
        }
        // code here
        return dist;
        
    }
}
