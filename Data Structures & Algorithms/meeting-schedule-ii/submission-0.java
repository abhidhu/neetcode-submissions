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
    public int minMeetingRooms(List<Interval> intervals) {
        // Arrays.sort(intervals, (a,b)-> a.start-b.start);
        Collections.sort(intervals, (a,b)-> a.start-b.start);
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int ans=0;
        for(Interval i: intervals){
            while(!pq.isEmpty() && pq.peek() <= i.start){
                pq.poll();
            }
            pq.offer(i.end);
            ans=Math.max(ans, pq.size());
        }
        return ans;
    }
}
