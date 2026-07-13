class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            String key=new String(arr);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());//adds the array list empt lisdst so t hat if anaf=grams comes thenb it can add them in the l9st
            }
            map.get(key).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
