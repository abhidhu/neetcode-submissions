class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=-1;
        int j=intervals.length;
        //find i and j value after i our new interval will go and before j our new interval will go
        for(int n=0;n<intervals.length;n++){
            if(intervals[n][1]<newInterval[0]){
                i=n;
            }
            if(intervals[n][0]>newInterval[1]){
                j=n;
                break;
            }//
        }
        boolean isOverlapping = j-i>1; //means can be used same input array
        //let use new array first then optimise for single array
        int temp=intervals.length-j+i+2;
        int[][] ans = new int[temp][2];
        //add first i element in interval
        for(int n=0; n<=i;n++){
            ans[n]=intervals[n];
        }
        //now add merged intervals if any 
        int left=newInterval[0];
        int right = newInterval[1];
        if(i+1<intervals.length && isOverlapping){
            left = Math.min(intervals[i+1][0], left);
        }
        if(j-1>=0 && isOverlapping){
             right=Math.max(right, intervals[j-1][1]);
        }
        newInterval[0]=left;
        newInterval[1]=right;
        temp=i+1;
        ans[temp++]=newInterval;
        //add remaining intervals from j onwards
        for(int n=j;n<intervals.length;n++){
            ans[temp++]=intervals[n];
        }
        return ans;
    }
}