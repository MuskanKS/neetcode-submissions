class LRUCache {
    class Custom{
        int key;
        int value;
        Custom(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private ArrayList<Custom> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new ArrayList<>();
    }
    
    public int get(int key) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).key == key){
                Custom node = list.get(i);
                list.remove(node);
                list.add(node);

                return node.value;
            }
        }
        return -1;
    }
    
    public void put(int key, int value) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).key == key){
                list.get(i).value = value;

                Custom node = list.get(i);
                list.remove(i);
                list.add(node);

                return;
            }
        }
        list.add(new Custom(key, value));

        if(list.size() > capacity){
            list.remove(0);
        }
        
    }
}


















