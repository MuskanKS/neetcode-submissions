class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        
        wind = [0] * 128
        left = 0
        maxFreq = 0
        maxLen = 0


        for right in range(len(s)):
            ch = s[right]
            idxr = ord(ch)
            wind[idxr] += 1
            maxFreq = max(maxFreq, wind[idxr])

            while left < right and (right - left + 1) - maxFreq > k:
                leftchar = s[left]
                leftidx = ord(leftchar)
                wind[leftidx] -= 1
                left += 1
            maxLen = max(maxLen, right - left + 1)

        return maxLen
            