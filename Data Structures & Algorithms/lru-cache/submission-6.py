class Node:
    def __init__(self, key: int, value: int):
        self.key = key
        self.value = value

        self.prev = None 
        self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capactiy = capacity
        self.cache = {}
        
        self.left = Node(0, 0)
        self.right = Node(0, 0)

        self.left.next = self.right
        self.right.prev = self.left

    def __add_most_recent(self, node: Node) -> None:
        last = self.right.prev
        last.next = node
        node.next = self.right
        self.right.prev = node
        node.prev = last

    def __remove(self, node: Node) -> None:
        next_node = node.next
        prev_node = node.prev

        next_node.prev = prev_node
        prev_node.next = next_node

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        
        node = self.cache[key]
        self.__remove(node)
        self.__add_most_recent(node)

        return node.value
        

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            node.value = value
            self.__remove(node)
            self.__add_most_recent(node)
            return 

        node = Node(key, value)
        self.cache[key] = node
        self.__add_most_recent(node)

        if len(self.cache) > self.capactiy:
            least_used = self.left.next
            self.__remove(least_used)
            del self.cache[least_used.key]
        
