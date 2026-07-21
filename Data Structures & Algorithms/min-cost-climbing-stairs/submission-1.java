class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //lest iterate over a cost and find the answer
        int prev=cost[0];
        int next = cost[1];
        //first by modifing the array
        for(int i=2; i<cost.length;i++){
            int temp=next;
            next = cost[i]+ Math.min(temp, prev);
            prev=temp;
        }
        return Math.min(prev, next);
    }
}