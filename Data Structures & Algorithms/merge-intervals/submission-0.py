class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        st = []
        intervals.sort()
        for interval in intervals:
            curStart, curEnd = interval[0], interval[1]
            
            if not st or curStart > st[-1][1]:
                st.append(interval)
            else:
                st[-1][0] = min(st[-1][0], curStart)
                st[-1][1] = max(st[-1][1], curEnd)

        return st
            

