class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        hm = {}
        left = 0
        maxLen = 0
        maxFreq = 0

        for right in range(len(s)):
            ch = s[right]
            hm[ch] = hm.get(ch, 0) + 1
            maxFreq = max(maxFreq, hm.get(ch))

            while right - left + 1 - maxFreq > k:
                leftchar = s[left]
                hm[leftchar] = hm.get(leftchar, 0) - 1
                left += 1
            maxLen = max(maxLen, right - left + 1)
        
        return maxLen