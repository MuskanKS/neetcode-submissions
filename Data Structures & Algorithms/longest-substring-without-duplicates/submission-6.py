class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hm = {}
        left = 0
        maxLen = 0

        for right in range(len(s)):
            while s[right] in hm:
                del hm[s[left]]
                left +=1 
            hm[s[right]] = right
            newLen = right - left + 1
            maxLen = max(maxLen, newLen)

        return maxLen


