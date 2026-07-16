class Solution {
    public String foreignDictionary(String[] words) {
        if(words.length==1) return words[0].substring(0,1);
        Set<Character> uniqie = new HashSet<>();
      Map<Character, List<Character>> map = new HashMap<>();
      Map<Character, Integer> count = new HashMap<>();
      for(int i=1; i<words.length;i++){
        helperUnique(words[i], uniqie);
        helperUnique(words[i-1], uniqie);
        char[] chars = helper(words[i-1], words[i]);
        if(chars==null) return "";//input is invalid
        if(chars.length==0) continue;
        map.computeIfAbsent(chars[0], key -> new ArrayList<>()).add(chars[1]);
        count.put(chars[1], count.getOrDefault(chars[1], 0)+1);
        count.put(chars[0], count.getOrDefault(chars[0], 0));
      }
      //now lets build queue and add all element with 0 into queue
      ArrayDeque<Character> dq = new ArrayDeque<>();
      for(char c :  count.keySet()){
        if(count.get(c)==0){
            dq.offerLast(c);
        }
      }
      StringBuilder sb = new StringBuilder("");
      while(!dq.isEmpty()){
        char i =dq.pollFirst();
        sb.append(i);
        List<Character> list = map.get(i);
        if(list!=null && !list.isEmpty()){
            for(char c: list){
                count.put(c, count.getOrDefault(c, 1)-1);
                if(count.get(c)==0) dq.offerLast(c);
            }
        }
      }
      for(char c :  count.keySet()){
        if(count.get(c)!=0){
            return "";
        }
      }
      String ans = sb.toString();
      for(int i=0; i<ans.length(); i++){
        uniqie.remove(ans.charAt(i));
      }
      for(char ch: uniqie){
        sb.append(ch);
      }
      return sb.toString();

    }

    private void helperUnique(String str, Set<Character> set){
        for(int i=0; i<str.length();i++){
            set.add(str.charAt(i));
        }
    }
    //method to handle things 
    private char[] helper(String word1, String word2){
        int i=0;
        while(i<word1.length() && i<word2.length()){
            char c1 = word1.charAt(i);
            char c2=word2.charAt(i);
            i++;
            if(c1==c2) continue;
            char[] arr = new char[2];
            arr[0]=c1;
            arr[1]=c2;
            return arr;
        }
        if(word1.length()<=word2.length()){
            return new char[0];
        }
        return null;
    }
}
