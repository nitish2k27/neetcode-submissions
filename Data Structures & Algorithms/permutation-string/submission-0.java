class Solution {
    public boolean checkInclusion(String s1, String s2) {
      int left=0;
      int[] reqfre=new int[26];//we are making the freq map so 26 i8sn size you can use hasap map if required
      for(int i=0;i<s1.length();i++){
            reqfre[s1.charAt(i)-'a']++;
      }  
      int[] window=new int[26];//basically to make sure that freq map of the window we are checkig have samre freq of that of the coparing string
      for(int right=0;right<s2.length();right++){
        window[s2.charAt(right)-'a']++;
        if((right-left+1)>s1.length()){
            window[s2.charAt(left)-'a']--;
            left++;
        }
        if((right-left+1)==s1.length()){
            boolean ans=checkfrequencyofcharacters(window,reqfre);
            if(ans){
                return true;
            }
        }
      }
      return false;
    }
    public boolean checkfrequencyofcharacters(int[] window,int[] reqfre){
        for(int i=0;i<26;i++){
            if(window[i]!=reqfre[i]){
                return false;
            }
        }
        return true;
    }
}
