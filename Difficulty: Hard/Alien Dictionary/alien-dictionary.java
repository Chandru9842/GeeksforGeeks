class Solution {
    public  List<Integer> dfs(int V, ArrayList<ArrayList<Integer>>adj, List<Integer>ans){
        int indegree[]=new int[V];
        Deque<Integer>q=new ArrayDeque<>();
        for(int i=0;i<V;i++){
            for(int j:adj.get(i)){
                indegree[j]++;
            }
        }
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int el=q.peek();
            q.poll();
            ans.add(el);
            for(int it:adj.get(el)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.offer(it);
                }
            }
        }
        return ans;
        
    }
    public String findOrder(String[] words) {
        int n=words.length;
        Set<Character>set=new HashSet<>();
        for(int i=0;i<words.length;i++){
            for(char j:words[i].toCharArray()){
                set.add(j);
            }
        }
        int V=set.size();
        HashMap<Character,Integer>map=new HashMap<>();
        HashMap<Integer,Character> revMap = new HashMap<>();
        int idx=0;
        for(char j:set){
            map.put(j,idx);
            revMap.put(idx,j);
            idx++;
        }
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            // for(int j=0;i<n;j++){
                String s1=words[i];
                String s2=words[i+1];
                   // Invalid prefix case
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }

                int len=Math.min(s1.length(),s2.length());
                for(int ptr=0;ptr<len;ptr++){
                    if(s1.charAt(ptr)!=s2.charAt(ptr)){
                        adj.get(map.get(s1.charAt(ptr))).add(map.get(s2.charAt(ptr)));
                        break;
                    }
                }
            
        }
        List<Integer>topo=new ArrayList<>();
         topo = dfs(V, adj,new ArrayList<>());
           if (topo.size() != V) {
            return "";
        }
        String ans="";
        for(int i=0;i<topo.size();i++){
            ans=ans+revMap.get(topo.get(i));
        }
        return ans;
       
        
    }
}