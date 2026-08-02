/* Definition for Node
class Node
{
    int data;
    Node left;
    Node right;
    Node(int val)
    {
        this.data = val;
        left = null;
        right = null;
    }
}
*/

class Solution {
    void dfs(Node root,ArrayList<ArrayList<Integer>>lst, ArrayList<Integer>ans){
        if(root==null){
            return;
        }
        ans.add(root.data);
        if(root.left==null&&root.right==null){
            lst.add(new ArrayList<>(ans));
            ans.remove(ans.size()-1);
            return;
        }
        dfs(root.left,lst,ans);
        dfs(root.right,lst,ans);
        ans.remove(ans.size()-1);
    }
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>>lst=new ArrayList<>();
        ArrayList<Integer>ans=new ArrayList<>();
        dfs(root,lst,ans);
        return lst;
        
    }
}