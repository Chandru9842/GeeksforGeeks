class Pair{
    int node;
    int parent;
    public Pair(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}
class Solution {
    public boolean bfs(int s,int V,ArrayList<ArrayList<Integer>>adj,boolean[]vis){
        vis[s]=true;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(s,-1));
        while(!q.isEmpty()){
            int node=q.peek().node;
            int parent=q.peek().parent;
            q.poll();
            for(int adjNode:adj.get(node)){
                if(vis[adjNode]==false){
                    vis[adjNode]=true;
                    q.offer(new Pair(adjNode,node));
                }
                else if(parent!=adjNode){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           adj.get(u).add(v);
           adj.get(v).add(u);
        }
        boolean[]vis=new boolean[V];
        for(int i=0;i<V;i++){
            vis[i]=false;
        }
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(bfs(i,V,adj,vis)){
                    return true;
                }
            }
        }
        return false;
        // Code here
        
    }
}