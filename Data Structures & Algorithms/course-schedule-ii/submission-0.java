class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] arr = new int[numCourses];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0; i<prerequisites.length;i++){
            arr[prerequisites[i][0]]++;
            map.computeIfAbsent(prerequisites[i][1], k -> new HashSet<>()).add(prerequisites[i][0]);
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i=0; i<arr.length;i++){
            if(arr[i]==0){
                dq.offerLast(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!dq.isEmpty()){
            int i = dq.size();
            while(i>0){
                int num = dq.pollFirst();
                for(int j:  map.getOrDefault(num, Collections.emptySet())){
                    arr[j]--;
                    if(arr[j]==0){
                        dq.offerLast(j);
                    }
                }
                ans.add(num);
                i--;
            }
        }
        for(int i=0; i<arr.length;i++){
            if(arr[i]!=0){
                return new int[0];
            }
        }
        int[] temp = new int[ans.size()];
        for(int i=0;i<temp.length;i++){
            temp[i]=ans.get(i);
        }
        return temp;

    }
}