class Solution {
    public boolean checkValidString(String s) {
        // Stack to store indices of open brackets '('
        Stack<Integer> openBrackets = new Stack<>();
        // Stack to store indices of asterisks '*'
        Stack<Integer> asterisks = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == '(') {
                openBrackets.push(i);
            } else if (ch == '*') {
                asterisks.push(i);
            } else { // ch == ')'
                // Try to balance using an open bracket first
                if (!openBrackets.isEmpty()) {
                    openBrackets.pop();
                } 
                // If no open bracket, use an asterisk as '('
                else if (!asterisks.isEmpty()) {
                    asterisks.pop();
                } 
                // If neither is available, the string is invalid
                else {
                    return false;
                }
            }
        }
        
        // Match remaining open brackets with remaining asterisks
        while (!openBrackets.isEmpty() && !asterisks.isEmpty()) {
            // An open bracket must appear BEFORE the asterisk matching it
            if (openBrackets.peek() > asterisks.peek()) {
                return false; 
            }
            openBrackets.pop();
            asterisks.pop();
        }
        
        // If all open brackets are matched, the string is valid
        return openBrackets.isEmpty();
    }
}