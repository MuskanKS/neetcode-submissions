class TimeMap {
    // create a custom class to store the value and timestamp
    class Custom{
        String value;
        int timestamp;
        Custom(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    // create a hashmap to store the values
    HashMap<String, List<Custom>> hm;

    public TimeMap() {
        hm = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        hm.putIfAbsent(key, new ArrayList<>());
        hm.get(key).add(new Custom(value, timestamp));
        
    }
    
    public String get(String key, int timestamp) {
        if(!hm.containsKey(key)){
            return "";
        }
        List<Custom> list = hm.get(key);
        
        int left = 0;
        int right = list.size() - 1;

        String res = "";

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(list.get(mid).timestamp <= timestamp){
                res = list.get(mid).value;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return res;
    }
}
