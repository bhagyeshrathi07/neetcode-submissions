class LRUCache:

    def __init__(self, capacity: int):
        self.cap = capacity
        self.table = {}
        self.left, self.right = Node(0, 0), Node(0, 0)
        self.left.next, self.right.prev = self.right, self.left

    # we always add to the right and remove from the left (when cap is max)
    def add(self, node) -> None:
        prev = self.right.prev
        prev.next = node
        node.next = self.right
        self.right.prev = node
        node.prev = prev
    
    def remove(self, node) -> None:
        prev, next = node.prev, node.next
        prev.next, next.prev = next, prev
        

    def get(self, key: int) -> int:
        if key in self.table:
            self.remove(self.table[key])
            self.add(self.table[key])
            return self.table[key].val
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.table:
            self.remove(self.table[key])
        self.table[key] = Node(key, value)
        self.add(self.table[key])

        if len(self.table) > self.cap:
            lru = self.left.next
            self.remove(lru)
            del self.table[lru.key]

class Node:
    def __init__(self, key, val):
        self.key, self.val = key, val
        self.prev = self.next = None