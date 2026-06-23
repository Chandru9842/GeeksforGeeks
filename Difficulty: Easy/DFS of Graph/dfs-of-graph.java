class Solution {
    public void dfs1(int node,boolean[]visited,ArrayList<Integer>lst,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        lst.add(node);
        for(int node1:adj.get(node)){
            if(!visited[node1]){
                dfs1(node1,visited,lst,adj);
            }
        }
        
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[]visited=new boolean[adj.size()+1];
        visited[0]=true;
        ArrayList<Integer>lst=new ArrayList<>();
        dfs1(0,visited,lst,adj);
        return lst;
    }
}