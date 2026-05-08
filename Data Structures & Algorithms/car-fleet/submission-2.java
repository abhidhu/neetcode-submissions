class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[] indices = IntStream.range(0, position.length)
          .boxed()
          .sorted(Comparator.comparingInt(i-> position[i]))
          .mapToInt(ele -> ele)
          .toArray();

        ArrayDeque<Double> stack = new ArrayDeque<>();
        for(int i=indices.length-1; i>=0; i--){
            int j = indices[i];
            double currentTime = (double) (target - position[j]) / speed[j];
            if(stack.isEmpty()){
                stack.offerLast(currentTime);
            }
            else{
                if(currentTime > stack.peekLast()){
                    stack.offerLast(currentTime);
                }
            }
        }
        return stack.size();
    }   
}
