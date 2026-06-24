class Solution {
    void dfs(int row,int col,int[][]vis,char[][]grid,ArrayList<String>shape,int brow,int bcol){
         vis[row][col] = 1;

        shape.add((row - brow) + "," + (col - bcol));
        int[]delrow={-1,0,1,0};
        int[]delcol={0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+delrow[i];
            int ncol=col+delcol[i];
            if(nrow>=0&&nrow<n&&ncol>=0&&ncol<m&&vis[nrow][ncol]==0&&grid[nrow][ncol]=='L'){
                
                dfs(nrow,ncol,vis,grid,shape,brow,bcol);
            }
        }
        

       
    }
    public int countDistinctIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int [][]vis=new int[n][m];
        Set<ArrayList<String>>set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((grid[i][j] == 'L' && vis[i][j] == 0)){
                    ArrayList<String>shape=new ArrayList<>();
                    dfs(i,j,vis,grid,shape,i,j);
                    set.add(shape);
                
            }
            }
        }
        return set.size();
        // code here
        
    }
}