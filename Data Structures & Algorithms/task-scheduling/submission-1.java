class Solution {
      public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b)-map.get(a));
        for(char c : map.keySet()){
            pq.offer(c);
        }
        int ans=0;
        while(!pq.isEmpty()){
            int i=pq.size();
            List<Character> list = new ArrayList<>();
            for(int j=0; j<i&&j<n;j++){
                char c = pq.poll();
                ans++;
                map.put(c, map.get(c)-1);
                if(map.get(c)>0){
                    list.add(c);
                }
            }
            if(!list.isEmpty()){
                pq.addAll(list);
                if(i<=n){
                    ans+=n-i+1;
                }
            }
        }
        return ans;
      }
  }