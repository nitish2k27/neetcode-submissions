class Solution {
    public int[] countBits(int n) {
        
        int res[]=new int[n+1];
        int num=0;
        
     while(num<n+1){
        int count=0;
        for(int i=0;i<32;i++){  
            if((num&(1<<i))!=0){
                count++;
            }
        }
        res[num]=count;
        num++;
            }
       return res;
    }
}
