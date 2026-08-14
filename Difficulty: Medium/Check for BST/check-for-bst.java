/* Structure of a Binary Search Tree node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {
    public static boolean dfs(Node root,Long min,Long max){
        if(root==null){
            return true;
        }
        if(root.data>=max||root.data<=min){
            return false;
        }
        boolean left=dfs(root.left,min,(long)root.data);
        boolean right=dfs(root.right,(long)root.data,max);
        return left&&right;
      
    }
    public boolean isBST(Node root) {
        Long min=Long.MIN_VALUE;
        Long max=Long.MAX_VALUE;
        boolean ans=dfs(root,min,max);
        return ans;
        
        
    }
}