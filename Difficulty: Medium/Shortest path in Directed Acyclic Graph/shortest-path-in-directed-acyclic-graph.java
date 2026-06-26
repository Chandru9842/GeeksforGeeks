class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public void dfs(int node,int[]vis,ArrayList<ArrayList<Pair>>adj,Stack<Integer>ans){
        vis[node]=1;
        for(Pair it:adj.get(node)){
            if(vis[it.first]==0){
                dfs(it.first,vis,adj,ans);
            }
        }
        ans.push(node);
        // return ans;
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Pair>());
            
        }
        for(int i=0;i<E;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int w=edges[i][2];
            adj.get(u).add(new Pair(v,w));
        }
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,vis,adj,st);
                
            }
        }
        int dis[]=new int[V];
        for(int i=0;i<V;i++){
            dis[i]=(int)(1e9);
        }
        dis[0]=0;
        while(!st.isEmpty()){
            int node=st.peek();
            st.pop();
            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).first;
                int w=adj.get(node).get(i).second;
                if(dis[node] != (int)1e9&&dis[node]+w<dis[v]){
                    dis[v]=w+dis[node];
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dis[i]==(int)1e9){
                dis[i]=-1;
            }
        }
        return dis;
    }
}