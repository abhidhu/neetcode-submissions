class TimeMap {
    Map<String, List<Value>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Value(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        if(timestamp < map.get(key).getFirst().timestamp){
            return "";
        }
        return helper(map.get(key), timestamp);
    }

    private String helper(List<Value> values, int target){
        int left = 0;
        int right = values.size();
        while(left < right){
            int mid = left + (right - left)/2;
            if(values.get(mid).timestamp < target){
                left = mid + 1;
            } else {
                right = mid ;
            }
        }
        if(left >= values.size()){
            return values.getLast().value;
        }
        if(values.get(left).timestamp <= target){
            return values.get(left).value;
        }
        if(left == 0){
            return "";
        }
        return  values.get(left-1).value;
    }
}

public record Value(String value, int timestamp){ }

//   alice -> happy, 1
//   alice -> sad , 3
//   10, 20
//15
