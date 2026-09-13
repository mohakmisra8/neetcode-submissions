class Solution:
    def minimumDifference(self, nums: List[int], k: int) -> int:
        nums.sort()
        left = 0
        right = k-1
        res = float("inf")
        while right < len(nums):
            res = min(res, nums[right]-nums[left])
            left +=1
            right +=1
        return res