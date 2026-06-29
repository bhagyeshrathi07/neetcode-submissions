class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if not nums:
            return 0
        unique = set(nums)
        longest = 1
        for num in unique:
            curr = num
            if curr - 1 not in unique:
                curr_longest = 1
                while curr + 1 in unique:
                    curr_longest += 1
                    curr += 1
                longest = max(longest, curr_longest)
        return longest