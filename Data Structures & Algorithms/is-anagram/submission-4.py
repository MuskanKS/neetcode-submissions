class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hm1 = {}
        hm2 = {}

        for i in range(len(t)):
            ch = t[i]
            hm1[ch] = hm1.get(ch, 0) + 1
        
        for i in range(len(s)):
            ch = s[i]
            hm2[ch] = hm2.get(ch, 0) + 1

        return hm1 == hm2