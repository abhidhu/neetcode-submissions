class Solution {
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String str : strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int left =0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '#'){
                int size = helper(str.substring(left, i));
                i++;
                ans.add(str.substring(i, i+size));
                i=i+size;
                left=i;
            }
        }
        return ans;
    }

    private int helper(String str){
        return Integer.valueOf(str);
    }
}
