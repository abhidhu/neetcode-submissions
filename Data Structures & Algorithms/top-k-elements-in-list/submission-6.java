class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0; i< nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // int[] list = new int[nums.length +1];
        
        List<List<Integer>> list = new ArrayList<>(nums.length +1);
        for(int i=0; i< nums.length +1; i++){
            list.add(new ArrayList<>());
        }

        for(Integer i : map.keySet()){
        int temp = map.get(i);
            list.get(temp).add(i); 
        }


        // for(int i=0; i< nums.length; i++){
        //     int temp = map.get(nums[i]);
        //     List l = list.get(temp);
        //     l.add(nums[i]);
        //     list.add(temp, l);

        // }

        int[] ans = new int[k];
        Collections.reverse(list);
        for(List<Integer> l : list){
            if(!l.isEmpty()){
                for(Integer i : l){
                    ans[--k]=i;
                    if(k==0){
                        return ans;
                    }
                }
                
            }
        }
        return ans;





        // int[] ans = new int[k];
        // for(int i=list.length-1; i>=0; i--){
        //     if(list[i] != 0){
        //         ans[--k]=list[i];
        //         if(k==0){
        //             return ans;
        //         }
        //     }
        // }
        // return new int[]{-1};










































        //Native solution
        // Map<Integer, Integer> map = new HashMap<>();
        // for(Integer i: nums){
        //     map.put(i, map.getOrDefault(i, 0)+1);
        // }

        // List<Integer> list = map.keySet().stream().sorted((a, b) -> map.get(b)-map.get(a)).collect(Collectors.toList());

        // list = list.subList(0, k);
        // int[] ans = new int[list.size()];
        // int j = 0;
        // for(Integer i : list){
        //     ans[j++]=i;
        // }
        // return ans;

        //Solution 2 after practice
        // Map<Integer, Integer> map = new HashMap<>();
        // for(Integer i: nums){
        //     map.put(i, map.getOrDefault(i, 0)+1);
        // }

        // List<List<Integer>> list = new ArrayList<>(nums.length+1);
        // for(int i=0; i<nums.length+1;i++){
        //     list.add(new ArrayList<>());
        // }
        
        // for(Integer i : map.keySet()){
        //     Integer temp = map.get(i);
        //     list.get(temp).add(i);
        // }
        // int[] ans = new int[k];
        // // Collections.reverse(list);
        // for(int j=list.size()-1; j>= 0; j--){
        //     List<Integer> l = list.get(j);
        //     if(l != null && l.size() > 0){
        //         for(Integer i: l){
        //             if(k<=0){
        //                 break;
        //             }
        //             ans[--k]=i;
        //         }
        //     }
        // }
        // return ans;
    }
}
