class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int  first=0;//2
        int sec=0;//7
        int third=0;//5
        for(int i=0; i<triplets.length; i++){
            int[] arr = triplets[i];
            if(arr[0]<=target[0] && arr[1]<=target[1]&&arr[2]<=target[2]){
                first=Math.max(first, arr[0]);
                sec=Math.max(sec, arr[1]);
                third=Math.max(third, arr[2]);
            }
            
        }

        return first==target[0] && sec== target[1] && third==target[2];
    }
}