class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sMap = [0] * 26
        tMap = [0] * 26

        for _ in s:
            sMap[ord(_) - ord('a')] += 1
        
        for _ in t:
            tMap[ord(_) - ord('a')] += 1
        
        return sMap == tMap
