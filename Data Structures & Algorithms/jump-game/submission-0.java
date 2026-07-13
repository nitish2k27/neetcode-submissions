class Solution {
    public boolean canJump(int[] nums) {
        int lastindxtoreach=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=lastindxtoreach){
                lastindxtoreach=i;
            }
        }
  
    return lastindxtoreach == 0;//when last index ==first index thenall jumps are [poosible]
    }
}
