class Solution {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int left = 0;
        int right = 0;
        for(int i=0; i<height.length; i++){
            left = Math.max(left, height[i]);
            right = Math.max(right, height[height.length-1-i]);
            leftMax[i]=left;
            rightMax[height.length-1-i]=right;
        }

        int ans = 0;
        for(int i=0; i<height.length; i++){
            int min = Math.min(leftMax[i], rightMax[i]);
            if(min-height[i]>0){
                ans+=min-height[i];
            }
        }

        return ans;
    }
}
