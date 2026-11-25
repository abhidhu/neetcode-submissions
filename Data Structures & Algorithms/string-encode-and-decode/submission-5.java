class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");

        for(int i=0; i<strs.size(); i++) {
            sb.append(strs.get(i).length()).append("#").append(strs.get(i));
        }
        return sb.toString();
    }

    //5#Hello5#world

    public List<String> decode(String str) {
        int i=0;
        List<String> ans = new ArrayList<>();
        while(i<str.length()) {
            //every time first iteration should be check how much character in string to take it
            int j = checkSizeOfString(i, str);
            int size = Integer.parseInt(str.substring(i, j));
            int start = j + 1;
            int end = start + size;
            ans.add(str.substring(start, end));
            i=end;
        }
        return ans;
    }

    

    private int checkSizeOfString(int i, String str) {
        for(int j= i+1; j<str.length(); j++ ) {
            if(str.charAt(j)=='#') {
                return j;//this will be the no of char in next stirng
            }
        }
        return 0;
    }
}
