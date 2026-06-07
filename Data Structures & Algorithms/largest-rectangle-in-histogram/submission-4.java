class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int ans=0;
        // for(int i=0; i<heights.length;i++){
        //     int val=0;
        //     while(!dq.isEmpty() && dq.peekLast()[0]>heights[i]){
        //         int[] temp=dq.pollLast();
        //         val = i-temp[1];
        //         val=val*temp[0];
        //         ans=Math.max(ans, val);
        //         val = temp[1];
        //         val=val>0?val:0;
        //     }
        //     int[] temp=new int[2];
        //     temp[0]=heights[i];
        //     temp[1]=val!=0&&val<i? val:i;
        //     dq.offerLast(temp);                
        // }
        for(int i=0; i<heights.length; i++){
            int start = i;
            while(!dq.isEmpty() && dq.peekLast()[0] > heights[i]){
                int[] temp = dq.pollLast();
                ans = Math.max(ans, temp[0] * (i - temp[1]));
                start = temp[1]; // extend start left
            }
            dq.offerLast(new int[]{heights[i], start});
        }
        int n=heights.length;
        while(!dq.isEmpty()){
            int[] temp=dq.pollLast();
            int val=n- temp[1];
            val=val*temp[0];
            ans=Math.max(ans, val);
        }
        return ans;
    }
}
