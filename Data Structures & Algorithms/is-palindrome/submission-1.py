class Solution:
    def isPalindrome(self, s: str) -> bool:
        clean = "".join(ch.lower() for ch in s if ch.isascii() and ch.isalnum())
        reverse = ""

        for i in range(len(clean) - 1, -1, -1):
            reverse += clean[i]

        return clean == reverse
