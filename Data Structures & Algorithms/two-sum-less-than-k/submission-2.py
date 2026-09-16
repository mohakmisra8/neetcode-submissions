class Solution:
    def twoSumLessThanK(self, nums: List[int], k: int) -> int:
        nums.sort()

        closestSum= -1
        for left in range(len(nums)):
            for right in range(left+1, len(nums)):
                sum = nums[left] +nums[right]
                if sum < k:
                    closestSum = max(closestSum, sum)
        
        return closestSum

        
        