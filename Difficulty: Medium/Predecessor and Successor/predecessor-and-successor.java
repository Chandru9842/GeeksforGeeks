class Solution {
    void successor(Node root,int key,ArrayList<Node> ans){
        Node succ=null;
        while(root!=null){
            if(key>=root.data){
                root=root.right;
            }
            else{
                succ=root;
                root=root.left;
            }
            
        }
        ans.add(succ);
       
        
    }
    void predecessor(Node root,int key,ArrayList<Node> ans){
        Node pre=null;
        while(root!=null){
            if(root.data>=key){
                root=root.left;
            }
            else{
                pre=root;
                root=root.right;
            }
            
        }
        ans.add(pre);
        
    }
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node>ans=new ArrayList<>();
        predecessor(root,key,ans);
        successor(root,key,ans);

        return ans;
        
    }
}