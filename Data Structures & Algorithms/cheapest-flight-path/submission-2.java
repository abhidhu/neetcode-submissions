class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[src]=0;//source always 0

        while(k>=0){
            int[] temp = new int[n];
            this.copy(arr, temp);
            for(int i=0; i<flights.length;i++){
                if(arr[flights[i][0]] < Integer.MAX_VALUE){
                    int d = arr[flights[i][0]] + flights[i][2];
                    if(temp[flights[i][1]] > d){
                        temp[flights[i][1]]=d;
                    }
                }
            }
            arr=temp;
            k--;
        }
        return arr[dst]==Integer.MAX_VALUE ? -1 : arr[dst];
    }
    private void copy(int[] from, int[] to){
        for(int i=0;i<from.length;i++){
            to[i]=from[i];
        }
    }
}