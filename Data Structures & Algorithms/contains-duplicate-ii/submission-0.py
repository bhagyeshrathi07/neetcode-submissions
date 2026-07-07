class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        l = 0
        window = set()
        for r, num in enumerate(nums):
            while abs(l - r) > k:
                window.remove(nums[l])
                l += 1
            
            if num in window:
                return True
            else:
                window.add(num)

        return False    
            