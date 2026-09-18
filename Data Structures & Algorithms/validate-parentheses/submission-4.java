class Solution {
    public boolean isValid(String s) {
        
        if((s.length() % 2) != 0){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                if(dq.isEmpty()){
                    return false;
                }
                char c1 = dq.pollLast();
                if(c1!=map.get(c)){
                    return false;
                }
                continue;
            } 
            dq.offerLast(c);
        }
        return dq.isEmpty();
    }

}