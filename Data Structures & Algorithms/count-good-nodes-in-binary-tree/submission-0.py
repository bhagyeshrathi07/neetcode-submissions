# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        count = 0

        if not root: 
            return 0
        
        def dfs(maxSoFar, node):
            cnt = 0
            if node.val >= maxSoFar:
                cnt += 1
            maxSoFar = max(maxSoFar, node.val)
            if node.right:
                cnt += dfs(maxSoFar, node.right)
            if node.left:
                cnt += dfs(maxSoFar, node.left)
            return cnt
        
        count += dfs(float('-inf'), root)
        return count
