class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int max=0;
        for(int i=0;i<s.length();i++){
            int[]hash=new int[26];
            for(int j=i;j<s.length();j++){
                if(hash[s.charAt(j)-'a']==1){
                    break;
                }
                hash[s.charAt(j)-'a']=1;
                max=Math.max(max,j-i+1);
            }
        }
        return max;
    }
}