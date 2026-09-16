class Solution {
    public boolean checkValidString(String s) {
        int openCount =0, closeCount=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='(' || c=='*'){
                openCount++;
            }else{
                openCount--;
            }

            c = s.charAt(s.length()-1-i);
            if(c==')' || c=='*'){
                closeCount++;
            }
            else{
                closeCount--;
            }
            if(closeCount < 0 || openCount < 0){
                return false;
            }

        }
        return true;
    }
}