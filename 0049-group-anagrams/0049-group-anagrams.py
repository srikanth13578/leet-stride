from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: list[str]) -> list[list[str]]:
        res = defaultdict(list)
        for s in strs:
            sorted_key = "".join(sorted(s))
            res[sorted_key].append(s)  
        return list(res.values())