class Solution {
    public ArrayList<Integer> kDistanceNodes(Node root, int target, int k) {
        ArrayList<Integer>ans=new ArrayList<>();
        HashMap<Node,Node>parent=new HashMap<>();
        Deque<Node>q=new ArrayDeque<>();
        q.offer(root);
        Node newnode=null;
        while(!q.isEmpty()){
            Node node=q.poll();
            if(node.data==target){
                newnode=node;
            }
            if(node.left!=null){
                parent.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                q.offer(node.right);
            }
        }
        HashSet<Node>vis=new HashSet<>();
        vis.add(newnode);
        q.offer(newnode);
        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            // count++;
            for(int i=0;i<size;i++){
                
                Node root1=q.poll();
                if(k==count){
                    ans.add(root1.data);
                }
                if(root1.left!=null&&!vis.contains(root1.left)){
                    vis.add(root1.left);
                    q.offer(root1.left);
                }
                if(root1.right!=null&&!vis.contains(root1.right)){
                    vis.add(root1.right);
                    q.offer(root1.right);
                }
                if(parent.containsKey(root1)&&!vis.contains(parent.get(root1))){
                    vis.add(parent.get(root1));
                    q.offer(parent.get(root1));
                }
                // count++;
                
            }
            count++;
        }
        
        Collections.sort(ans);
        return ans;
        
    }
}