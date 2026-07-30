/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    static int height(Node root){
        if(root==null){
            return 0;
        }
        int left=height(root.left);
        int right=height(root.right);
        int sum=1+Math.max(left,right);
        return sum;
    }
    
    public boolean isBalanced(Node root) {
        if(root==null){
            return true;
        }
        int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        return isBalanced(root.left)&&isBalanced(root.right);
        // code here
        
    }
}