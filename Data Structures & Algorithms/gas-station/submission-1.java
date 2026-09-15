class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i=0; i< gas.length; i++){
            sum = sum + gas[i] - cost[i];
        }

        if(sum < 0){
            return -1;//handle when we cant finish the circle
        }
        int max = 0;
        int ans =0;
        
        for(int i=0; i<gas.length;i++){
            sum = gas[i]-cost[i];
            max = max + sum;
            if(max < 0){
                max = 0;
                ans = i+1;
            }
        }
        return ans;

    }
}