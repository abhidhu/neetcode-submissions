class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        //add first interval from intervals to ans
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] interval = intervals[i];
            int[] last = ans.getLast();//its array list so o(1) unlike linked list
            //check does it overlapping or not
            if(interval[0]<=last[1]){
                last[0]=Math.min(last[0], interval[0]);
                last[1]=Math.max(last[1], interval[1]);
            }else{
                ans.add(interval);
            }
        }
        int[][] finalAns = new int[ans.size()][2];
        for(int i=0; i<finalAns.length;i++){
            finalAns[i]=ans.get(i);
        }
        return finalAns;
    }
}