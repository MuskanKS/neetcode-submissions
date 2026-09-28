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
        String res = "";

        for(Custom custom : hm.get(key)){
            if(custom.timestamp <= timestamp){
                res = custom.value;
            }
        }
        return res;
    }
}
