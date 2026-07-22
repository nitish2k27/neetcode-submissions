class Solution {
    public boolean isAlienSorted(String[] words, String order) {
     int[] wordmap=new int[26];
     for(int i=0;i<order.length();i++){
        wordmap[order.charAt(i)-'a']=i;
     }
     boolean checked=false;   
     for(int i=0;i<words.length-1;i++){
        String word1=words[i];
        String word2=words[i+1];
        int minlength=Math.min(word1.length(),word2.length());
        for(int j=0;j<minlength;j++){
            char word1char=word1.charAt(j);
            char word2char=word2.charAt(j);
            if(word1char!=word2char){
                if(wordmap[word1char-'a']>wordmap[word2char-'a']){
                    return false;
                }
                checked =true;
                break;
            }
            if(!checked&&word1.length()>word2.length()){
                return false;
            }
        }
     }
     return true;
    }
}