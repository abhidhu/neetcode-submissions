class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] map = new int[26];
        int[] temp = new int[26];

        for (char c : s1.toCharArray()) map[c - 'a']++;

        int match = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0) match++;
        }

        for (int j = 0; j < s2.length(); j++) {
            // Add right character
            char add = s2.charAt(j);
            temp[add - 'a']++;
            if (temp[add - 'a'] == map[add - 'a']) match++;
            else if (temp[add - 'a'] == map[add - 'a'] + 1) match--;

            // Remove left character when window exceeds size
            if (j >= s1.length()) {
                char remove = s2.charAt(j - s1.length());
                temp[remove - 'a']--;
                if (temp[remove - 'a'] == map[remove - 'a']) match++;
                else if (temp[remove - 'a'] == map[remove - 'a'] - 1) match--;
            }

            if (match == 26) return true;
        }
        return false;
    }
}