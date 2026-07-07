class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1):
            return False

        s1_map = {}
        s2_map = {}
        
        for c in s1:
            s1_map[c] = 1 + s1_map.get(c, 0)

        l = 0

        for r, c in enumerate(s2):
            s2_map[c] = 1 + s2_map.get(c, 0)

            if r - l + 1 > len(s1):
                left_char = s2[l]
                s2_map[left_char] -= 1

                if s2_map[left_char] <= 0:
                    del s2_map[left_char]
                l += 1
            
            if s1_map == s2_map:
                return True
        return False