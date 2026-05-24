class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null || strs.length==0){
            return null;
        }
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length;i++){
            String str = strs[i];
            Map<Character, Integer> t = new HashMap<>();
            for(int j=0; j<str.length(); j++){
                t.put(str.charAt(j), t.getOrDefault(str.charAt(j), 0) +1);
            }
            map.computeIfAbsent(t, t1-> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
