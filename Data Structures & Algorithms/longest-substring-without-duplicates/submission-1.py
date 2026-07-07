class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        longest = 0
        window = set()

        for r, char in enumerate(s):
            while char in window:
                window.remove(s[l])
                l += 1
            window.add(char)
            longest = max(r - l+1, longest)
        return longest
