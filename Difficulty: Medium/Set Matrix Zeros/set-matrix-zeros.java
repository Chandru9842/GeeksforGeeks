class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int[]rowarray=new int[row];
        int[]colarray=new int[col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(mat[i][j]==0){
                    rowarray[i]=1;
                    colarray[j]=1;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(rowarray[i]==1||colarray[j]==1){
                    mat[i][j]=0;
                }
            }
        }
        // code here
        
    }
}