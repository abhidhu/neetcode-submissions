class Solution {
    public int[][] merge(int[][] intervals) {
        // if(intervals==null || intervals.length==0) return new int[0][0]; no need of this line as intervals will never be null or 0
        List<int[]> ans = new ArrayList<>(intervals.length);
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ans.add(intervals[0]);
        int[] temp=intervals[0];
        for(int i=1; i<intervals.length;i++){
            if(temp[1]>=intervals[i][0]){
                //merge intervals
                temp[1]=Math.max(intervals[i][1], temp[1]);
            }else{
                ans.add(intervals[i]);
            }
            temp=ans.getLast();
        }
        return ans.toArray(new int[ans.size()][]);
    }
}