class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] count=new int[numCourses];
        for(int i=0;i<pre.length;i++){
            map.computeIfAbsent(pre[i][1], key -> new ArrayList<>()).add(pre[i][0]);
            count[pre[i][0]]++;
        }
        ArrayDeque<Integer>  dq = new ArrayDeque<>();
        for(int i=0;i<count.length;i++){
            if(count[i]==0)
              dq.offerLast(i);
        }
        int[] ans = new int[numCourses];
        int index = 0;
        while(!dq.isEmpty()){
            int i = dq.pollFirst();
            ans[index++]=i;
            List<Integer> list = map.get(i);
            if(list!=null && !list.isEmpty()){
                for(int node : list){
                    if(--count[node]==0 ){
                        dq.offerLast(node);
                    }
                }
            }
        }
        for(int i=0;i<count.length;i++){
            if(count[i]>0) return new int[0];
        }
        return ans;
    }
}