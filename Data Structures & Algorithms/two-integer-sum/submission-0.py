class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        complementMap = {}

        for i, num in enumerate(nums):
            complement = target - num
            if complement in complementMap:
                return [complementMap[complement], i]
            complementMap[num] = i