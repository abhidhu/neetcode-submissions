class TimeMap {

    Map<String, List<Data>> map = new HashMap<>();

    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        Data data = new Data(timestamp, value);
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(data);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Data> data = map.get(key);
        if(data == null || data.isEmpty()){
            return "";
        }
        int left = 0;
        int right = data.size()-1;
        while(left <=right){
            int mid = left + (right - left)/2;
            if(data.get(mid).time == timestamp){
                return data.get(mid).value;
            }
            else if(data.get(mid).time < timestamp){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return right >= 0 ? data.get(right).value : "";
    }
}

class Data{
    int time;
    String value;
    Data(int time, String value){
        this.time=time;
        this.value = value;
    }
}
