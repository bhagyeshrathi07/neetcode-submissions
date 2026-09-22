class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        new_start = newInterval[0]
        new_end = newInterval[1]

        for i, interval in enumerate(intervals):
            cur_start = interval[0]
            cur_end = interval[1]

            if newInterval[1] < intervals[i][0]:
                res.append(newInterval)
                return res + intervals[i:]
            elif newInterval[0] > intervals[i][1]:
                res.append(intervals[i])
            else:
                newInterval = [
                    min(newInterval[0], intervals[i][0]),
                    max(newInterval[1], intervals[i][1])   
                ]
        res.append(newInterval)       
        return res

