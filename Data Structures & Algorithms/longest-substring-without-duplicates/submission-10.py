class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hs = set()
        maxLen = 0
        left = 0

        for right in range(len(s)):
            ch = s[right]
            while ch in hs:
                hs.remove(s[left])
                left += 1
            hs.add(ch)
            length = right - left + 1
            maxLen = max(maxLen, length)

        return maxLen
        

        