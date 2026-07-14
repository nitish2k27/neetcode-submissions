class Solution {
    public boolean checkValidString(String s) {

        // low  = Minimum possible number of unmatched '('
        // high = Maximum possible number of unmatched '('
        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // A real '(' always increases the number of unmatched '('.
                // So both the minimum and maximum increase.
                low++;
                high++;
            }

            else if (ch == ')') {
                // A ')' closes one unmatched '(' if possible.
                // So both the minimum and maximum decrease.
                low--;
                high--;
            }

            else { // ch == '*'

                // Greedy Idea:
                // To get the MINIMUM unmatched '(',
                // assume '*' behaves like ')'.
                low--;

                // To get the MAXIMUM unmatched '(',
                // assume '*' behaves like '('.
                high++;
            }

            // If even the MAXIMUM possible unmatched '(' is negative,
            // there are more ')' than '(' in every possible interpretation.
            // Hence, the string can never become valid.
            if (high < 0)
                return false;

            // Minimum unmatched '(' can never be negative.
            // If it becomes negative, treat it as 0 because
            // '*' could have been an empty string instead of ')'.
            low = Math.max(low, 0);
        }

        // If the minimum possible unmatched '(' is 0,
        // there exists at least one interpretation where
        // every '(' gets matched.
        return low == 0;
    }
}