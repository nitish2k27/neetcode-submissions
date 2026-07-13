class Solution {
    public int jump(int[] nums) {
       int jumps=0;
        int farthest=0;
        int inSameWindowlast=0;
        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest,i+nums[i]);
            if(i==inSameWindowlast){//meaing explored all the number in the window of jump
                    jumps++;
                    inSameWindowlast=farthest;//it assign the maximum you can travel with the window you jumped any one amoung the elemt in the window
            }
        }
        return jumps;  
    }
}
