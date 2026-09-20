class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s2.length() < s1.length()){
            return false;
        }

        int[] arr = new int[26];
        int match = 0;
        for(int i=0; i<s1.length(); i++){
            arr[s1.charAt(i)-'a']++;
        }

        int[] ans = new int[26];
        int left=0;
        for(int right=0; right<s2.length(); right++){
            ans[s2.charAt(right)-'a']++;

            while(left <= right && ans[s2.charAt(right)-'a'] > arr[s2.charAt(right)-'a']){
                ans[s2.charAt(left)-'a']--;
                left++;
            }
            if(1+right-left ==s1.length()){
                return true;
            }
        }
        return false;
    }

}
