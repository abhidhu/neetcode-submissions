class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(3);
        Deque<Character> dequeu = new ArrayDeque<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                dequeu.offerLast(c);
            } else{
                if(!(map.get(c)==dequeu.peekLast())){
                    return false;
                }
                dequeu.pollLast();
            }
        }
        return dequeu.isEmpty() ? true : false;
    }
}