class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> ans = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();
        for(List<String> ticket : tickets){
            map.computeIfAbsent(ticket.getFirst(), k-> new ArrayList<>()).add(ticket.getLast());
        }
        for(String str: map.keySet()){
            Collections.sort(map.get(str));
            Collections.reverse(map.get(str));
        }
        helper("JFK", ans, map, 1+tickets.size());
        return ans;
    }

    private boolean helper(String from, List<String> ans, Map<String, List<String>> map, int n){
      ans.addLast(from);
      if(ans.size()==n){
        return true;
      }
      List<String> temp = map.get(from);
      if(temp==null || temp.isEmpty()){
        ans.removeLast();
        return false;
      }
      
      for(int i=temp.size()-1; i>=0; i--){
        //backstrack
        String str = temp.get(i);
        temp.remove(i);
        boolean flag = helper(str, ans, map, n);
        if(flag) return flag;
        temp.add(i, str);
      }
      ans.removeLast();
      return false;
    }
}
