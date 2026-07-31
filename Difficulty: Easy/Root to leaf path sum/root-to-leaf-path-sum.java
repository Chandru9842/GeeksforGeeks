/*
// A Binary Tree node
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
    static boolean res(Node root,int tar){
        if(root==null){
            return false;
        }
        if(root.data==tar&&(root.left==null&&root.right==null)){
            return true;
        }
         boolean a=   res(root.left,tar-root.data);
        boolean b=res(root.right,tar-root.data);
        return a||b;
    }
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int target) {
        // Your code here
        boolean ans=res(root,target);
        return ans;
    }
}