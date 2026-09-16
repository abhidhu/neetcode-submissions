class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            arr[c-'a']=i;
        }
        List<Integer> ans = new ArrayList<>();
        int max = 0;
        int last = -1;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            max = Math.max(max, arr[c-'a']);
            if(max==i){
                ans.add(max-last);
                last=max;
                max=max+1;
            }
        }
        return ans;
    }
}