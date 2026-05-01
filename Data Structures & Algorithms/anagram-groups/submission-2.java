class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {


        Map<String, List<String>> map =  new HashMap<>();
        for(int i=0; i<strs.length; i++){
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            map.computeIfAbsent(s, k -> new ArrayList()).add(strs[i]);
        }
        List<List<String>> ans = new ArrayList<>();
        // map.forEach(( k, v) -> {
        //     ans.add(v);
        // });
        for(List<String> s : map.values()){
            ans.add(s);
        }
        return ans;






































        
        // Map<String, List<String>> map = new HashMap<>();
        // for(int i=0;i<strs.length;i++){
        //     String str = strs[i];
        //     char[] chars = str.toCharArray();
        //     Arrays.sort(chars);
        //     String sorted = new String(chars);
        //     if(map.containsKey(sorted)){
        //         map.get(sorted).add(str);
        //     }else{
        //         List<String> tempList = new ArrayList<>();
        //         tempList.add(str);
        //         map.put(sorted, tempList);
        //     }
        // }
        // return new ArrayList<>(map.values());
    }

    // private List<List<String>> check(List<List<String>> ans, List<String> input, String s){
    //     if(input == null || input.size() == 0){
    //         return ans;
    //     }
    //     List<String> temp = new ArrayList<>();
    //     Map<Character, Integer> map = new HashMap<>();
    //     for(int i = 0; i<s.length(); i++){
    //         if(map.containsKey(s.charAt(i))){
    //             map.put(s.charAt(i), map.get(s.charAt(i)+1));
    //         }
    //         else{
    //             map.put(s.charAt(i), 1);
    //         }
    //     }
    //     for(String str : input){
    //         for(int i=0; i<str.length();i++){
    //             if(map.containsKey(str.charAt(i))){
                    
    //             }
    //             else{
    //                 break;
    //             }
    //         }
    //     }
    // }
}
