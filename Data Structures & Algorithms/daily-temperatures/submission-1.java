class Solution {
    public int[] dailyTemperatures(int[] temps) {
        ArrayDeque<Integer> stack = new ArrayDeque<>(temps.length);
        int[] ans = new int[temps.length];
        for(int i=0; i<temps.length;i++){
            while(stack.peekLast() != null && temps[stack.peekLast()] < temps[i]){
                int temp = stack.pollLast();
                ans[temp] = i-temp;
            }
            stack.offerLast(i);
        }
        return ans;
    }
}
