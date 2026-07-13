class Solution {
    public boolean validPalindrome(String s) {
        
        int left=0;
        int right=s.length()-1;
        
        while(left<right){
        if(s.charAt(left)!=s.charAt(right)){
            return isPalindrome(s,left+1,right)||isPalindrome(s,left,right-1);
            //basically it will check weather by skiippping left character cana palindrome exists
            // or by skipping right csn palindrome exists
        }
        left++;
        right--;
        }
        return true;
    } 
    public boolean isPalindrome(String s,int left,int right){
        while(left<right){
             if(s.charAt(left)!=s.charAt(right)){
           return false;//basically even after skiipping 
           //one charater there exists no palindrome on this sequence
                }
        left++;
        right--;
        }
        return true;
        }    

}