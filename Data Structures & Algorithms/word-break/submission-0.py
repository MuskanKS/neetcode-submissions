class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        memo = [-1] * (len(s) + 1)

        return self.dp(s, 0, wordSet, memo)

    def dp(self, s, idx, wordSet, memo):
        if idx == len(s):
            return True
        
        if memo[idx] != -1:
            return memo[idx]

        for end in range(idx + 1, len(s) + 1):
            word = s[idx:end]
            if word in wordSet and self.dp(s, end, wordSet, memo):
                memo[idx] = True
                return True
            
        memo[idx] = False
        return False

