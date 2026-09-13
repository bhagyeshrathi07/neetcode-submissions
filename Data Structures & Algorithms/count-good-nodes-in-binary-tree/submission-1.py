# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        cnt = 0

        if not root: 
            return 0
        
        def dfs(maxSoFar, node):
            nonlocal cnt
            if node.val >= maxSoFar:
                cnt += 1
            maxSoFar = max(maxSoFar, node.val)
            if node.right:
                dfs(maxSoFar, node.right)
            if node.left:
                dfs(maxSoFar, node.left)
            return cnt
        
        cnt += dfs(float('-inf'), root)
        return cnt
