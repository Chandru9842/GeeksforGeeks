/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Solution {
    boolean symmetric(Node left,Node right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.data!=right.data){
            return false;
        }
        boolean lft=symmetric(left.left,right.right);
        boolean rht=symmetric(left.right,right.left);
        return lft&&rht;
        
    }
    public boolean isSymmetric(Node root) {
        boolean ans=symmetric(root.left,root.right);
        return ans;
        
        
        
    }
}