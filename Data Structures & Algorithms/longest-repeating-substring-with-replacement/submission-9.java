class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;//0
        int j=i;
        int ans = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>(); //A=4, B=2
        while(j<s.length()){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            max = findMax(map);
            if(j-i+1-max<=k){
                ans = Math.max(ans, j-i+1); //5
            }
            else{
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) -1);
                i++;//1
            }
            j++;//5
        }
        return ans;
    }
    private int findMax(Map<Character, Integer> map){
        int max = 0;
        for(Integer i : map.values()){
            if(max<i){
                max=i;
            }
        }
        return max;
    }
}
