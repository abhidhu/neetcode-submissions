class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<t.length();i++){
            if(!map.containsKey(t.charAt(i))){
                return false;
            }
            if(map.get(t.charAt(i)) < 1){
                return false;
            }
            map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
        }
        return true;



































        // if(s.length() != t.length()){
        //     return false;
        // }
        // Map<Character, List<Character>> map = new HashMap<>();
        // for(int i = 0; i < s.length(); i++){
        //    if( map.containsKey(s.charAt(i))){
        //     map.get(s.charAt(i)).add(s.charAt(i));
        //    } else{
        //     List<Character> charList = new ArrayList<>();
        //     charList.add(s.charAt(i));
        //     map.put(s.charAt(i), charList);
        //    }
        // }
        // for(int i = 0; i<t.length(); i++){
        //     if(!map.containsKey(t.charAt(i))){
        //         return false;
        //     }
        //     List<Character> list = map.get(t.charAt(i));
        //     if(list == null || list.size() == 0){
        //         return false;
        //     }
        //     list.removeFirst();
        // }
        // return true;
    }
}
