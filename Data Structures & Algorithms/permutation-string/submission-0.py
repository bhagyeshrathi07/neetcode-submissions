class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        s1_char = {}
        s2_char = {}

        if len(s1) > len(s2):
            return False

        for c in s1:
            s1_char[c] = 1 + s1_char.get(c, 0)
        
        l = 0;
        for r, c in enumerate(s2):
            s2_char[c] = 1 + s2_char.get(c, 0)

            if r - l + 1 > len(s1):
                left_char = s2[l]
                s2_char[left_char] -= 1

                if s2_char[left_char] == 0:
                    del s2_char[left_char]
                
                l += 1
            
            if s1_char == s2_char:
                return True

        return False
