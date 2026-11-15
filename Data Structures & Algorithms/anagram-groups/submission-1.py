class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hm = {}

        for i in range(len(strs)):
            ch = strs[i]
            s = "".join(sorted(ch))
            if s not in hm:
                hm[s] = []
            hm[s].append(ch)
            # muskan yad rakhna list h to .append karke dalo tum hm key list mei
        
        return list(hm.values())