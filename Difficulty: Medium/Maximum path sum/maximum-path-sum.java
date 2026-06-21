/*
Definition for Node
class Node{
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private int maxpath(Node root,int[]dia){
        if(root==null){
            return 0;
        }
        int left=Math.max(0,maxpath(root.left,dia));
        int right=Math.max(0,maxpath(root.right,dia));
        dia[0]=Math.max(dia[0],left+right+root.data);
        return Math.max(left,right)+root.data;
    }
    int findMaxSum(Node root) {
        // code here
        int dia[]=new int[1];
        dia[0] = Integer.MIN_VALUE;
        maxpath(root,dia);
        return dia[0];
    }
}