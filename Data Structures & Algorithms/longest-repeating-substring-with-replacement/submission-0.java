class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int maxfreq=0;
        int maxsize=0;
        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxfreq=Math.max(maxfreq,map.get(s.charAt(right)));
            //int currwindow=right-left+1;
            while((right-left+1)-maxfreq>k){
                map.put(s.charAt(left),map.getOrDefault(s.charAt(left),0)-1);
                if(map.get(s.charAt(left))==0){
                    map.remove(s.charAt(left));
                   
                }
                 left++;
            }
        maxsize=Math.max(maxsize,right-left+1);
        }
        return maxsize;
    }
}
