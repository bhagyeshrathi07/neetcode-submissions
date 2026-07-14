"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        copy = {None: None}

        cur = head
        while cur:
            node = Node(cur.val, None, None)
            copy[cur] = node
            cur = cur.next
        
        cur = head
        while cur:
            copy[cur].next = copy.get(cur.next)
            copy[cur].random = copy.get(cur.random)
            cur = cur.next 
        return copy[head]


