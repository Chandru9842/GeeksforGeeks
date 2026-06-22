/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    void addlefttree(Node root,ArrayList<Integer> ans){
        Node curr=root.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                ans.add(curr.data);

                
            }
            if(curr.left!=null){
                curr=curr.left;
                
            }
            else{
                curr=curr.right;
            }
        }
        
    }
    void addrighttree(Node root,ArrayList<Integer>ans){
        root=root.right;
        ArrayList<Integer>lst=new ArrayList<>();
        while(root!=null){
            if(!isLeaf(root)){
                lst.add(root.data);
            }
            if(root.right!=null){
                root=root.right;
            }
            else{
                root=root.left;
            }
        }
        for(int i=lst.size()-1;i>=0;i--){
            ans.add(lst.get(i));
        }
        
    }
    void addleafnode(Node root,ArrayList<Integer>ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null){
            addleafnode(root.left,ans);
        }
        if(root.right!=null){
            addleafnode(root.right,ans);
        }
        
    }
    boolean isLeaf(Node root){
        return root.left==null&&root.right==null;
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        
        // code here
        ArrayList<Integer>ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        if(isLeaf(root)==false){
            ans.add(root.data);
            
        }
        addlefttree(root,ans);
        addleafnode(root,ans);
        addrighttree(root,ans);
        return ans;
    }
}