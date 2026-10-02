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
    private HashMap<Integer, Custom> hm;
    private LinkedList<Custom> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        list = new LinkedList<>();
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Custom node = hm.get(key);

        list.remove(node);
        list.addLast(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Custom node = hm.get(key);
            node.value = value;

            list.remove(node);
            list.addLast(node);

            return;
        }

        Custom node = new Custom(key, value);

        hm.put(key, node);
        list.addLast(node);

        if(list.size() > capacity){
            Custom lru = list.removeFirst();
            hm.remove(lru.key);
        }
        
    }
}


















