
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> tmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int left = 0;
        int formed = 0;
        
      
        int required = tmap.size(); 
        
        HashMap<Character, Integer> smap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            smap.put(rightChar, smap.getOrDefault(rightChar, 0) + 1);

           
            if (tmap.containsKey(rightChar) && smap.get(rightChar).equals(tmap.get(rightChar))) {
                formed++;
            }


            while (formed == required) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                char leftChar = s.charAt(left);
                smap.put(leftChar, smap.get(leftChar) - 1);

                
                if (tmap.containsKey(leftChar) && smap.get(leftChar) < tmap.get(leftChar)) {
                    formed--;
                }
                left++;
            }
        }

      
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}