class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t== null || t.length() != s.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<t.length(); i++){
            if(!map.containsKey(t.charAt(i)) || map.get(t.charAt(i)) == 0){
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i))-1);
        }
        return true;
    }
}

