class Solution:
    def validPalindrome(self, s: str) -> bool:
        left = 0
        right = len(s)-1

        while left < right:
            if s[left] != s[right]:
                skipLeft = s[left+1:right+1]
                skipRight = s[left:right]
                return skipLeft == skipLeft[::-1] or skipRight == skipRight[::-1]
            left +=1
            right -=1
        
        return True

        