class Solution {
    Map<Integer, List<Character>> map = null;
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits== null || digits.isBlank()) return ans;
        map=map != null ? map :getMap();
       helper(digits, 0, new StringBuilder(), ans);
       return ans;
    }

    private void helper(String str, int i, StringBuilder sb, List<String> ans){
        if(i==str.length()){
            ans.add(sb.toString());
            return;
        }
        Integer in = Integer.parseInt(str.substring(i, i+1));
        List<Character> chars = this.map.get(in);
        for(char c : chars){
            sb.append(c);
            helper(str, i+1, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }

    }

    private Map<Integer, List<Character>> getMap(){
        Map<Integer, List<Character>> map = new HashMap<>();
        List<Character> s2= new ArrayList<>();
        s2.add('a');
        s2.add('b');
        s2.add('c');
        map.put(2, s2);

        List<Character> s3= new ArrayList<>();
        s3.add('d');
        s3.add('e');
        s3.add('f');
        map.put(3, s3);

        List<Character> s4= new ArrayList<>();
        s4.add('g');
        s4.add('h');
        s4.add('i');
        map.put(4, s4);

        List<Character> s5= new ArrayList<>();
        s5.add('j');
        s5.add('k');
        s5.add('l');
        map.put(5, s5);

        List<Character> s6= new ArrayList<>();
        s6.add('m');
        s6.add('n');
        s6.add('o');
        map.put(6, s6);

        List<Character> s7= new ArrayList<>();
        s7.add('p');
        s7.add('q');
        s7.add('r');
        s7.add('s');
        map.put(7, s7);

        List<Character> s8= new ArrayList<>();
        s8.add('t');
        s8.add('u');
        s8.add('v');
        map.put(8, s8);


        List<Character> s9= new ArrayList<>();
        s9.add('w');
        s9.add('x');
        s9.add('y');
        s9.add('z');
        map.put(9, s9);
        return map;
    }
}