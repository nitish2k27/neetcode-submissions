class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       
        int i=m-1;//indx of nums1 legall index
        int j=n-1;//legal ind of nums2
        int k=m+n-1;//basically to have the idea regrading the length of the array or the last index in nums1;
        while(i>=0&&j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k]=nums1[i];
                k--;
                i--;
            }
            else{
                nums1[k]=nums2[j];
                k--;
                j--;
            }
        }
        while(j>=0){//this loop usually takes place when m=0 and n have elemnts to be places in nums 1  or 
        //when nums1 are shorter then that of the nums 2
            nums1[k]=nums2[j];
            k--;
            j--;
        }
    }
}