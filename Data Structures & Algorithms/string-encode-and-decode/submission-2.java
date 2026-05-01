class Solution {
     public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
     }
      public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<str.length()){
            if('#' != str.charAt(i)){
                i++;
                continue;
            }
            int size = findInteger(j, i, str);//5
            ans.add(str.substring(++i, i+size));
            i=i+size;
            j=i;
        }
        return ans;

      }
      private int findInteger(int j, int i, String str){
        String s = str.substring(j, i);
        try{
            return Integer.parseInt(s);
        }catch(NumberFormatException e){

        }
        return 0;
      }
}
