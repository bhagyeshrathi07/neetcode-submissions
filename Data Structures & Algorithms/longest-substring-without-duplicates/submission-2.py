class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        max_len = 0
        unique = set()

        for r, char in enumerate(s):
            while char in unique:
                unique.remove(s[l])
                l += 1
            unique.add(char)
            max_len = max(max_len, r - l + 1)
        return max_len

