class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        hm = {}
        for ch in s:
            hm[ch] = hm.get(ch, 0) + 1

        for ch in t:
            if hm.get(ch) == 0 or ch not in hm:
                return False
            hm[ch] =hm.get(ch, 0) - 1
        
        return True
