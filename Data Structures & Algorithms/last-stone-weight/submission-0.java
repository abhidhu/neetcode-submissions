class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)-> b-a);  //(Comparator.reverse());
        for(int i=0;i<stones.length;i++){
            pq.offer(stones[i]);
        }
        while(!(pq.size()<2)){
            int first = pq.poll();
            int sec = pq.poll();
            int ans = Math.abs(first-sec);
            if(ans>0){
                pq.offer(ans);
            }
        }
        return pq.size()==0?0:pq.peek();
    }
}