from collections import deque

class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        
        dq = deque()
        dq.append(root)

        depth=0

        while dq:
            size = len(dq)
            for _ in range (size):
                curr = dq.popleft()
                if curr.left is not None:
                    dq.append(curr.left)
                if curr.right is not None:
                    dq.append(curr.right)
            
            depth += 1
            
        return depth
        