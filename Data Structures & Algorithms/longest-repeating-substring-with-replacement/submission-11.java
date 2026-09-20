class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        
        int left = 0;
        int right = 0;
        int ans = 0;
        int maxFreq =0; //unitque 
        while(right < s.length() && left <= right){
          arr[s.charAt(right)-'A']++;
          int temp = helper(arr);
          //check does window valid if yes continue
          while(left <= right && (temp + k) < (1+ right - left)){
            arr[s.charAt(left)-'A']--;
            left++;
          }
          ans = Math.max(ans, ++right - left);
        }
        
        return ans;
    }

    private int helper(int[] arr){
      int ans =0;
      for(int i: arr){
        ans = Math.max(ans, i);
      }
      return ans;
    }
}
