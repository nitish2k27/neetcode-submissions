class Solution {
    public int maxArea(int[] heights) {
        int left=0;
        int right=heights.length-1;
        int maxarea=0;
        while(left<right){
           int area=(Math.min(heights[left],heights[right]))*(right-left);
            maxarea=Math.max(area,maxarea);
            if(heights[left]<heights[right]){
                left++;
            }
            else{
                right--;
            }
       
        }
             return maxarea;
    }
}
