class Solution {
    public int minTime(Node root, int target) {
        // to cretae a parent node
        int time=0;
        if(root==null){
            return time;
        }
        HashMap<Node,Node>map=new HashMap<>();
        Queue<Node>q=new ArrayDeque<>();
        q.offer(root);
        Node newnode=null;
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.data==target){
                newnode=node;
            }
            if(node.left!=null){
                map.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                map.put(node.right,node);
                q.offer(node.right);
            }
            
        }
        // to find the vis map;
        Set<Node>vis=new HashSet<>();
        // Node a=new Node(target);
        q.offer(newnode);
        vis.add(newnode);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                Node root1=q.poll();
                if(root1.left!=null&&!vis.contains(root1.left)){
                    vis.add(root1.left);
                    q.offer(root1.left);
                }
                if(root1.right!=null&&!vis.contains(root1.right)){
                    vis.add(root1.right);
                    q.offer(root1.right);
                }
                if(map.containsKey(root1)&&(!vis.contains(map.get(root1)))){
                    vis.add(map.get(root1));
                    q.offer(map.get(root1));
                    
                }
            }
            if(q.isEmpty()){
                break;
            }
            time++;
           
        }
        return time;
        
        
    }
}