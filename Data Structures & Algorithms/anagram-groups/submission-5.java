class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++){
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            map.computeIfAbsent(sorted, key -> new ArrayList<>()).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for(List<String> list : map.values()){
            ans.add(list);
        }
        return ans;
    }
}