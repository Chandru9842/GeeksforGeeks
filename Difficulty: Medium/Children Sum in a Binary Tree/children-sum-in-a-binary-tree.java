/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null){
            return true;
        }
        Deque<Node>q=new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.left==null&&node.right==null){
                continue;
            }
            int sum=0;
           int left=0;
           int right=0;
           if(node.left!=null){
               left=node.left.data;
           }
           if(node.right!=null){
               right=node.right.data;
           }
           sum=left+right;
            if(sum!=node.data){
                return false;
            }
            if(node.left!=null){
                q.offer(node.left);
            }
            if(node.right!=null){
                q.offer(node.right);
            }
            
        }
        return true;
    }
}