class Solution:
    def sortArrayByParity(self, nums: List[int]) -> List[int]:
        even, odd = [], []

        for num in nums:
            if num &1:
                odd.append(num)
            else:
                even.append(num)
        
        index = 0
        for e in even:
            nums[index] = e
            index +=1
        for o in odd:
            nums[index]= o
            index +=1
        
        return nums

        