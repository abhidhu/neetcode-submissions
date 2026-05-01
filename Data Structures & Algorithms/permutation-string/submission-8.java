class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int totalChars = s1Map.size();
        int matched = 0;

        for (int j = 0; j < s2.length(); j++) {
            // Add right character to window
            char add = s2.charAt(j);
            windowMap.put(add, windowMap.getOrDefault(add, 0) + 1);

            if (s1Map.containsKey(add) && windowMap.get(add).equals(s1Map.get(add))) {
                matched++;
            } else if (s1Map.containsKey(add) && windowMap.get(add).equals(s1Map.get(add) + 1)) {
                matched--;
            }

            // Remove left character when window exceeds size
            if (j >= s1.length()) {
                char remove = s2.charAt(j - s1.length());
                windowMap.put(remove, windowMap.get(remove) - 1);

                if (s1Map.containsKey(remove) && windowMap.get(remove).equals(s1Map.get(remove))) {
                    matched++;
                } else if (s1Map.containsKey(remove) && windowMap.get(remove).equals(s1Map.get(remove) - 1)) {
                    matched--;
                }
            }

            if (matched == totalChars) {
                return true;
            }
        }

        return false;
    }
}