class Solution {
    public int maxArea(int[] h) {
        int ans=0; //7
        int temp=0; 
        int left=0; //0
        int right=h.length-1; //7
        while(left<right){
            int min = h[left] < h[right] ? h[left] : h[right];
            temp = min * (right - left) ; //7
            if(temp>ans){
                ans=temp;
            }
            if(h[left] < h[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
