/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
} */

class Solution {
    private int height(Node root,int[] dia){
        if(root==null){
            return 0;
        }
        int lh=height(root.left,dia);
        int rh=height(root.right,dia);
        dia[0]=Math.max(dia[0],lh+rh);
        return 1+Math.max(rh,lh);
    }
    public int diameter(Node root) {
        // code here
        int dia[]=new int[1];
        height(root,dia);
        return dia[0];
    }
}