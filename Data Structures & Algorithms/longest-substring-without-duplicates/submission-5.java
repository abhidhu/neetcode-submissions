class Solution{
  public int lengthOfLongestSubstring(String s){
    if(s==null || s.isEmpty()) {
      return 0;
    }
    int max = 0;
    int left =0;
    int right =left;
    Set<Character> set = new HashSet<>();
    while(right < s.length()){
      char c = s.charAt(right);
      if(set.contains(c)){
        max = Math.max(max, set.size());
        while(s.charAt(left) != c){
          set.remove(s.charAt(left++));
        }
        set.remove(s.charAt(left++));
      }
      set.add(c);
      right++;
    }
    return Math.max(max, set.size());
  }
}
