class Solution {
    public void floydWarshall(int[][] dist) {
        int n=dist.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i][j]==1e8){
                    dist[i][j]=
                    (int)1e9;
                }
                if(i==j){
                    dist[i][j]=0;
                }
            }
        }
        // Code here
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                   if (dist[i][k] != (int)1e9 && dist[k][j] != (int)1e9) {
    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
}
                }
            }
        }
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(dist[i][j]==(int)1e9){
                    dist[i][j]=(int)1e8;
                }
            }}
    }
}