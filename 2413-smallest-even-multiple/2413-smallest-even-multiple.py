class Solution:
    def smallestEvenMultiple(self, n: int) -> int:
        ans = 0    
        if n % 2 == 0:
            ans = n
        else:
            ans = n * 2
        return ans
