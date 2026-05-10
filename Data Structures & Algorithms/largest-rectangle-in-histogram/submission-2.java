class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<List<Integer>> s = new ArrayDeque<>(heights.length);
        int ans=0;
        List<Integer> temp;
        for(int i=0; i<heights.length;i++){
            if(s.isEmpty()){
                temp = new ArrayList<>(2);
                temp.add(i);
                temp.add(heights[i]);
                s.offerLast(temp);
            }
            else if(s.peekLast().get(1) < heights[i]){
                temp = new ArrayList<>(2);
                temp.add(i);
                temp.add(heights[i]);
                s.offerLast(temp);
            }
            else{
                int j = i;
                while(!s.isEmpty() && s.peekLast().get(1) >= heights[i]){
                    temp = s.pollLast();
                    int area = (i- temp.get(0))*temp.get(1);
                    ans=Math.max(ans, area);
                    j = temp.get(0);
                }
                temp = new ArrayList<>(2);
                temp.add(j);
                temp.add(heights[i]);
                s.offerLast(temp);
            }
        }
        int i = heights.length;
        while(!s.isEmpty()){
            temp = s.pollLast();
            int area = (i-temp.get(0)) * temp.get(1);
            ans=Math.max(ans, area);
        }
        return ans;
    }
}
