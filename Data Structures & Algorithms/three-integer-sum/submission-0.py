class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []
        for i, a in enumerate(nums):
            if a > 0:
                break
            
            # skip duplicate first num choice
            if i > 0 and a == nums[i-1]:
                continue

            left = i + 1
            right = len(nums)-1

            while left < right:
                sum = nums[i] + nums[left] + nums[right]
                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else: 
                    res.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    # skip duplicate second num choice after finding first num
                    while nums[left] == nums[left-1] and left < right:
                        left += 1
        return list(res)
