class Solution {
    public String minWindow(String s, String t) {
        if(t.length()> s.length()){
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> temp = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int targetMatch = map.size();
        for(char c = 'a'; c<='z' ; c++){
            map.put(c, map.getOrDefault(c, 0));
            temp.put(c, 0);
        }
        for(char c = 'A'; c<='Z' ; c++){
            map.put(c, map.getOrDefault(c, 0));
            temp.put(c, 0);
        }
        String ans = "";
        int match = 0;
        int j=0;
        int i=0;
        while(j<s.length()){
            char c = s.charAt(j);
            temp.put(c, temp.getOrDefault(c, 0)+1);
            if(map.get(c) == temp.get(c)) {
                match ++;
            } 
            // else if(map.get(c) > temp.get(c) - 1) {
            //     match--;
            // }
            while(match == targetMatch && !(map.get(s.charAt(i)) == temp.get(s.charAt(i))) ){
                c = s.charAt(i);
                temp.put(c, temp.getOrDefault(c, 0) - 1);
                // if(map.get(c) == temp.get(c)) {
                //     match ++;
                // } else
                 if(map.get(c) == temp.get(c) + 1) {
                    match--;
                }  
                i++;              
            }
            if(match == targetMatch){
                ans = !ans.isEmpty() && ans.length() < s.substring(i, j+1).length() ? ans : s.substring(i, j+1);
            }
            j++;
        }


        return ans;
    }
}
