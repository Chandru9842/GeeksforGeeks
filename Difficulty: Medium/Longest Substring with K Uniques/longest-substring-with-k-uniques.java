class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        // int max=-1;
        // for(int i=0;i<s.length();i++){
        //     Set<Integer>set=new HashSet<>();
        //     for(int j=i;j<s.length();j++){
        //         set.add(s.charAt(j)-'a');
        //         if(set.size()==k){
        //             max=Math.max(max,j-i+1);

        //         }
        //     }
        // }
        // return max;
        
        HashMap<Character,Integer>map=new HashMap<>();
        int max=-1;
        int l=0;
        for(int r=0;r<s.length();r++){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            while(map.size()>k){
                map.put(s.charAt(l),map.getOrDefault(s.charAt(l),0)-1);
                if(map.get(s.charAt(l))==0){
                    map.remove(s.charAt(l));
                }
                l++;
                
            }if(map.size()==k){
            max=Math.max(max,r-l+1);
        }
        }
        return max;
    }
}