class Solution {
    public boolean isAnagram(String s, String t) {
      HashMap<Character,Integer> map=new HashMap<>();
      HashMap<Character,Integer> map1=new HashMap<>();
      if(s.length()!=t.length()){
        return false;
      }
      for(int i=0;i<s.length();i++){
        map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        map1.put(t.charAt(i),map1.getOrDefault(t.charAt(i),0)+1);
      }  
      if(map.equals(map1)){
        return true;
      }
      return false;
    }
}
