class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hm = {}
        maxLen = 0

        left = 0
        for right in range(len(s)):
            ch = s[right]
            while ch in hm:
                del hm[s[left]]
                left += 1
            hm[ch] = right
            length = right - left + 1
            maxLen = max(maxLen, length)
        return maxLen