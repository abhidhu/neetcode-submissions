class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        int ans=1;
        int i=0;
        int j=i;
        Map<Character, Integer> map = new HashMap<>();
        while(j<s.length()){
            if(map.containsKey(s.charAt(j))){
                ans = Math.max(j-i, ans);//2
                i= Math.max(i, map.get(s.charAt(j)) + 1);//2
            }
            map.put(s.charAt(j), j);
            j++;
        }
        return Math.max(ans, j-i);
    }
}
