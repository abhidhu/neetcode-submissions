class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] minDis = new int[n];
        int[] temp = new int[n];
        int INF = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minDis[i]=INF;
            temp[i]=INF;
        }
        minDis[src]=0;
        temp[src]=0;
        int j=0;
        while(j++<k+1){
            //iterate over all the edges
            for(int i=0; i<flights.length;i++){
                int[] ticket = flights[i];
                if(minDis[ ticket[0] ] != INF )  {

                    temp[ ticket[1] ]= Math.min(ticket[2]+minDis[ticket[0]],    temp[ticket[1]]);
                }
            }
            helper(temp, minDis);
        }
        return minDis[dst]==INF ? -1: minDis[dst];

    }

    private void helper(int[] from, int[] to){
        for(int i=0;i<from.length;i++){
            to[i]=from[i];
        }
    }
}