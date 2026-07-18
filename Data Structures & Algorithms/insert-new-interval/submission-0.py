class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        
        newstart, newend = newInterval[0], newInterval[1]
        res = []

        for i, interval in enumerate(intervals):
            curstart, curend = interval[0], interval[1]

            if newend < curstart:
                res.append([newstart, newend])
                return res + intervals[i:]

            elif curend < newstart:
                res.append(interval)

            else:
                newstart = min(curstart, newstart)
                newend = max(curend, newend)

        res.append([newstart, newend])
        return res
            

