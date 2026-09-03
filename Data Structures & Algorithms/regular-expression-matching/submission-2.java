class Solution {
    public boolean isMatch(String s, String p) {
        // Size +1 so we can memoize state when i == s.length() or j == p.length()
        // 0 = unvisited, 1 = false, 2 = true
        int[][] dp = new int[s.length() + 1][p.length() + 1];
        return helper(0, 0, dp, s, p);
    }

    private boolean helper(int i, int j, int[][] dp, String s, String p) {
        // Base case: pattern consumed -> true if string is also fully consumed
        if (j == p.length()) {
            return i == s.length();
        }

        if (dp[i][j] != 0) {
            return dp[i][j] == 2;
        }

        // Check if current characters match (ensure i is within bounds)
        boolean firstMatch = (i < s.length()) && 
                             (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');

        boolean ans = false;

        // If the next character in pattern is '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // Choice 1: Ignore x* (zero occurrences)
            // Choice 2: Use x* (if firstMatch is true, consume one char from s)
            ans = helper(i, j + 2, dp, s, p) || 
                  (firstMatch && helper(i + 1, j, dp, s, p));
        } else {
            // Standard single character match
            ans = firstMatch && helper(i + 1, j + 1, dp, s, p);
        }

        dp[i][j] = ans ? 2 : 1;
        return ans;
    }
}