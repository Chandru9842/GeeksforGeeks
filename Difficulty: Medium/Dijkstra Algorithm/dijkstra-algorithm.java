class Pair {
    int dist;
    int node;

    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        // Deque<Pair>q=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(w,v));
            adj.get(v).add(new Pair(w,u));
            
        }
        // PriorityQueue<>pr=new PriorityQueue<>(a,b){}/
          PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist)
                return a.dist - b.dist;   // Smaller distance first
            return a.node - b.node;       // If distances are equal, smaller node first
        });
        int[]dis=new int[V];
        
        Arrays.fill(dis,(int)1e9);
        dis[src]=0;
        pq.offer(new Pair(0,src));
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int dis1=cur.dist;
            int node=cur.node;
            if (dis1 > dis[node]) {
    continue;
}
            for(Pair it:adj.get(node)){
                int adjNode=it.node;
                int edgeWeight=it.dist;
                if(dis1+edgeWeight<dis[adjNode]){
                    dis[adjNode]=dis1+edgeWeight;
                    pq.add(new Pair(dis[adjNode],adjNode));
                }
            }
        }
        return dis;
        
        // code here
        
    }
}