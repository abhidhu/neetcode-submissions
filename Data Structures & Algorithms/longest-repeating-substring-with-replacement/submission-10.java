class Solution{
  public int characterReplacement(String s, int k) {
    if(s == null || s.length()==0){
      return 0;
    }
    if(s.length()<=k+1){
      return s.length();
    }
    Map<Character, Integer> map = new HashMap<>();
    int left =0;
    int right =0;
    int ans = 0;
    int maxFreq = 0;
    while(right < s.length()){
      char c = s.charAt(right);
      map.put(c, map.getOrDefault(c, 0)+1);
      maxFreq = Math.max(maxFreq, map.get(c));
      //check window is valid or not
      int windowSize = right-left+1;
      //window is now valid lets srink window from left
      while(windowSize - maxFreq > k){
        map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 1)-1);
        left++;
        windowSize = right-left+1;//or can be windowSize--
      }
      ans = Math.max(ans, windowSize);
      right++;
    }
    return ans;
  }
}