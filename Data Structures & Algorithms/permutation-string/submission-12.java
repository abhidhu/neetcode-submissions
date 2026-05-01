class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int totalChars = s1Map.size(); // unique chars we need to match
        int match = 0; // counts how many chars have equal frequency in window and s1

        for (int i = 0; i < s2.length(); i++) {
            // add right character into window
            char c = s2.charAt(i);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
            if (s1Map.containsKey(c) && s1Map.get(c).equals(windowMap.get(c))) {
                match++; // just became equal
            } else if (s1Map.containsKey(c) && s1Map.get(c).equals(windowMap.get(c) - 1)) {
                match--; // just crossed over from equal to one extra
            }

            // remove left character when window exceeds s1 size
            if (i >= s1.length()) {
                char c1 = s2.charAt(i - s1.length());
                windowMap.put(c1, windowMap.getOrDefault(c1, 0) - 1);
                if (s1Map.containsKey(c1) && s1Map.get(c1).equals(windowMap.get(c1))) {
                    match++; // just became equal after removal
                } else if (s1Map.containsKey(c1) && s1Map.get(c1).equals(windowMap.get(c1) + 1)) {
                    match--; // just dropped below equal after removal
                }
            }

            // check after window is correct size
            if (match == totalChars) {
                return true;
            }
        }

        return false;
    }
}