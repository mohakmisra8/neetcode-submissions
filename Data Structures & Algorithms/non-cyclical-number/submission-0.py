class Solution:
    def isHappy(self, n: int) -> bool:
        slow = n
        fast = self.sumOfSquares(n)

        while slow != fast:
            fast = self.sumOfSquares(fast)
            fast = self.sumOfSquares(fast)
            slow = self.sumOfSquares(slow)
        return True if fast == 1 else False
    
    def sumOfSquares(self, n:int) -> int:
        output = 0
        while n > 0:
            last_digit = n %10
            last_digit = last_digit **2
            output += last_digit
            n = n//10
        return output

        