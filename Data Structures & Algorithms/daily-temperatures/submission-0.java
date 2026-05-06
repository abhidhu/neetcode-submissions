class Solution {
    public int[] dailyTemperatures(int[] temps) {
        ArrayDeque<List<Integer>> stack = new ArrayDeque<>(temps.length);
        int[] ans = new int[temps.length];
        for(int i=0; i<temps.length;i++){
            while(stack.peekLast() != null && !stack.peekLast().isEmpty() && stack.peekLast().getFirst() < temps[i]){
                List<Integer> temp = stack.pollLast();
                ans[temp.get(1)] = i-temp.get(1);
            }
            List<Integer> list = new ArrayList<>(2);
            list.add(temps[i]); 
            list.add(i);
            stack.offerLast(list);
        }
        return ans;
    }
}
