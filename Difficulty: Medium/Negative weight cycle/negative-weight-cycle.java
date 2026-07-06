class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
        
    }
}
class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
       List<ArrayList<Pair>>adj=new ArrayList<>();
       for(int i=0;i<n;i++){
           adj.add(new ArrayList<>());
       }
       for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           int w=edges[i][2];
           adj.get(u).add(new Pair(v,w));
           
       }
       int dist[]=new int[n];
       Arrays.fill(dist,0);
    //   dist[0]=0;
       for(int i=0;i<n-1;i++){
           for(int u=0;u<n;u++){
               for(Pair it:adj.get(u)){
                   int adjnode=it.first;
                   int ew=it.second;
                   if(dist[u]+ew<dist[adjnode]){
                       dist[adjnode]=dist[u]+ew;
                   }
               }
           }
       }
       for(int u=0;u<n;u++){
           for(Pair it:adj.get(u)){
               int adjnode=it.first;
               int ew=it.second;
               if(dist[u]+ew<dist[adjnode]){
                   return 1;
               }
           }
       }
       return 0;
       
        
    }
}