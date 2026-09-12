class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        even,odd = [], []

        for n in nums:
            if n & 1:
                odd.append(n)
            else:
                even.append(n)
        
        index = 0
        for e in even:
            nums[index] = e
            index +=1
        for o in odd:
            nums[index] = o
            index +=1
        return nums