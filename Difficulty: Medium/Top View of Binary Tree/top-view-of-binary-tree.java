class Pair{
    Node node;
    int col;
    Pair(Node node,int col){
        this.node=node;
        this.col=col;
    }
}
class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer>ans=new ArrayList<>();
        Queue<Pair>q=new ArrayDeque<>();
        TreeMap<Integer,Integer>map=new TreeMap<>();
        if(root==null){
            return ans;
        }
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it=q.poll();
            Node node=it.node;
            int col=it.col;
            if(!map.containsKey(col)){
                map.put(col,node.data);
            }
            if(node.left!=null){
                q.offer(new Pair(node.left,col-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,col+1));
            }
        }
        for(int i:map.values()){
            ans.add(i);
        }
        
        return ans;
        
        
    }
}