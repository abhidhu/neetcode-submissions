class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        int max=intervals[0][1];
        int ans=0;
        for(int i=1;i<intervals.length;i++){
            if(!(max<=intervals[i][0])){
                ans++;
                max=Math.min(max, intervals[i][1]);
                continue;
            }
            max=Math.max(max, intervals[i][1]);
        }
        return ans;
    }
}