class Solution:
    def subsets(self, nums: list[int]) -> list[list[int]]:
        n = len(nums)
        output = []
        
        for i in range(1 << n):  
            current_subset = []
            for j in range(n):
               
                if (i >> j) & 1:
                    current_subset.append(nums[j])
            output.append(current_subset)
            
        return output