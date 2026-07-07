class Solution {
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][]) {
        // code here
        int n=graph.length;
        for(int i=0;i<n;i++){
            graph[i][i]=1;
        }
         for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = (graph[i][j] == 1 ||
                                  (graph[i][k] == 1 && graph[k][j] == 1))
                                  ? 1 : 0;
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                row.add(graph[i][j]);
            }
            ans.add(row);
        }

        return ans;
        
    }
}