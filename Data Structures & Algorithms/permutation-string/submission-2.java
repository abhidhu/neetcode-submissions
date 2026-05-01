class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(26);
        for(int i=0; i<s1.length();i++){
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int i=0;
        int j=0;
        Map<Character, Integer> temp = new HashMap<>();
        while(i<s2.length()){
            temp.put(s2.charAt(i), temp.getOrDefault(s2.charAt(i), 0) + 1);

            if(map.containsKey(s2.charAt(i)) && map.get(s2.charAt(i)) >= temp.get(s2.charAt(i))){
                if(i-j+1==s1.length()){
                    return true;
                }
                i++;
                continue;
            }
            temp = new HashMap<>();
            j++;
            i=j;
        }
        return false;
    }
}
