class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return []
        
        phone = {"2" : "abc", "3": "def", "4": "ghi", "5": "jkl", "6": "mno", "7": "pqrs", "8": "tuv", "9": "wxyz"}
        self.res = []
        self.temp = []
        self.backtrack(digits, 0, phone)
        return self.res
    
    def backtrack(self, digits, idx, phone):
        if idx == len(digits):
            self.res.append("".join(self.temp))
            return 
        
        letters = phone[digits[idx]]

        for letter in letters:
            self.temp.append(letter)
            self.backtrack(digits, idx + 1, phone)
            self.temp.pop()