class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        maxLen = 0
        hs = set()

        for right in range(len(s)):
            ch = s[right]
            while ch in hs:
                hs.remove(s[left])
                left += 1

            hs.add(ch)
            length = right - left + 1
            maxLen = max(maxLen, length)

        return maxLen

        