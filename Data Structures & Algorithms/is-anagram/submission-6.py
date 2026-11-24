class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        hm = {}
        for i in range(len(t)):
            ch = t[i]
            hm[ch] = hm.get(ch, 0) + 1
        for i in range(len(s)):
            ch = s[i]
            if ch in hm:
                hm[ch] = hm.get(ch) - 1
                if hm.get(ch) == 0:
                    del hm[ch]

        return not hm