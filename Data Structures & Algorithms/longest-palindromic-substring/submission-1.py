class Solution:
    def longestPalindrome(self, s: str) -> str:
        # we will solve this using center expansion
        if not s:
            return ""
        start = 0
        maxLen = 1
        for center in range(len(s)):
            # for odd length
            left = center
            right = center
            while left >= 0 and right < len(s) and s[left] == s[right]:
                currLen = right - left + 1
                if currLen > maxLen:
                    start = left
                    maxLen = currLen
                left -= 1
                right += 1
            
            # for even length
            left = center
            right = center + 1
            while left >= 0 and right < len(s) and s[left] == s[right]:
                currLen = right - left + 1
                if currLen > maxLen:
                    start = left
                    maxLen = currLen
                left -= 1
                right += 1
        return s[start: start + maxLen]
