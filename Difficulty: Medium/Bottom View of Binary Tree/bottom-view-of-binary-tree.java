class Pair{
    Node node;
    int col;
    
    public Pair(Node node,int col){
        this.node=node;
        this.col=col;
        
    }
    
}
class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        TreeMap<Integer,Integer>map=new TreeMap<>();
        Deque<Pair>q=new ArrayDeque<>();
        ArrayList<Integer>ans=new ArrayList<>();
        
        if(root==null){
            return ans;
        }
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            Pair it=q.poll();
            Node node=it.node;
            int line=it.col;
            map.put(line,node.data);
            if(node.left!=null){
                q.offer(new Pair(node.left,line-1));
            }
            if(node.right!=null){
                q.offer(new Pair(node.right,line+1));
            }
        }
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            ans.add(entry.getValue());
            
        }
        return ans;
        
       
        
    }
}