class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        unique = set(nums)
        longest = 0
        for num in unique:
            curr = num
            if curr - 1 not in unique:
                length = 1
                while curr + 1 in unique:
                    length += 1
                    curr += 1
                longest = max(longest, length)
        return longest