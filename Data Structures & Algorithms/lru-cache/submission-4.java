class LRUCache {
    class Custom{
        int key;
        int value;

        Custom prev;
        Custom next;

        Custom(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Custom> hm;
    private Custom head;
    private Custom tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        hm = new HashMap<>();
        
        head = new Custom(0, 0);
        tail = new Custom(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Custom node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void add(Custom node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;

    }
    
    public int get(int key) {
        if(!hm.containsKey(key)){
            return -1;
        }
        Custom node = hm.get(key);

        remove(node);
        add(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Custom node = hm.get(key);
            node.value = value;

            remove(node);
            add(node);

            return;
        }

        Custom node = new Custom(key, value);

        hm.put(key, node);
        add(node);

        if(hm.size() > capacity){
            Custom lru = head.next;
            remove(lru);
            hm.remove(lru.key);
        }
        
    }
}


















