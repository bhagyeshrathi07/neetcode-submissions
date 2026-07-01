class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        r = 0
        longest = 0
        unique_set = set()

        while r < len(s):
            while s[r] in unique_set:
                unique_set.remove(s[l])
                l += 1
            unique_set.add(s[r])
            r += 1
            longest = max(longest, r - l)
        return longest
        

