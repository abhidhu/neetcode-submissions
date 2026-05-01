class Solution {
    public int trap(int[] h) {
        int[] leftMax = new int[h.length];
        int rightMax=0;
        int ans=0;
        for(int i=1;i<h.length;i++){
            leftMax[i] = Math.max(leftMax[i-1], h[i-1]);
        }
        for(int i=h.length-2;i>=0;i--){
           rightMax=Math.max(rightMax, h[i+1]);
           ans+=Math.max(Math.min(rightMax, leftMax[i]) - h[i], 0);
        }
        return ans;
    }
}
