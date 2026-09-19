class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int left = 0; 
        int right = 0;
        while(right < s.length()){
          char c = s.charAt(right);
           if(set.contains(c)){
              while(left <= right && s.charAt(left) != c) { 
                set.remove(s.charAt(left++));
              }
              set.remove(s.charAt(left++));
           }
            set.add(c);
            right++;
           ans=Math.max(ans, right - left);
        }
        return Math.max(ans, right - left);
    }
}
