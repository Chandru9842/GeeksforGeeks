/* Structure of Binary Tree Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = this.right = null;
    }
}*/

class Solution {
    void dfs(Node root,List<Integer>lst,int level){
        if(root==null){
            return;
        }
        if(level==lst.size()){
            lst.add(root.data);
        }
        dfs(root.left,lst,level+1);
        dfs(root.right,lst,level+1);
      
    }
    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer>ans=new ArrayList<>();
        dfs(root,ans,0);
        return ans;
        // code here
        
    }
}