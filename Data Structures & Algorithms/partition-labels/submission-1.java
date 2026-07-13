class Solution {
    public List<Integer> partitionLabels(String s) {
     HashMap<Character,Integer>map=new HashMap<>();
     List<Integer>list=new ArrayList<>();
     int firstindx=0;
     int lastindx=0;
     for(int i=0;i<s.length();i++){  
        map.put(s.charAt(i),i);
     }   
     int start=0;
     int lastindxofpartition=0;
     for(int i=0;i<s.length();i++){
        lastindxofpartition=Math.max(lastindxofpartition,map.get(s.charAt(i)));  //it will calucale the ending indx of the poarton see if we have xyxxy first i find the last occurence of x it will be 3 and then i move formward in the subsequnce between 0 and 3 to find weather there exists any other number which will come after three y ocuurence is at 4 so i go there and updata end to the 4 because y occurence in partion one and its dplicate the lst ovccurence is at indx 4 
        //if last indx is calcuated and now at last indx of the partion 
        if(i==lastindxofpartition){
            list.add(lastindxofpartition-start+1);
            start=i+1;//its time to track new partion bascially
        }
     }
     return list;
    }
}
