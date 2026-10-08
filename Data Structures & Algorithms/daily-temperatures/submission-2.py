class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        st = []
        res = [0] * len(temperatures)

        # st [28] 

        for i, t in enumerate(temperatures):
            while st and t > st[-1][0]:
                temp, idx = st.pop()
                res[idx] = i - idx
            st.append((t, i))
        return res
                
