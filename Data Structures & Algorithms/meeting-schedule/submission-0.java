/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()<=1){
            return true;
        }
        Collections.sort(intervals, (a, b) -> a.start-b.start);
        int temp= Integer.MIN_VALUE;
        for(Interval i: intervals){
            if(!(temp<=i.start)){
                return false;
            }
            temp=i.end;
        }
        return true;
    }
}
