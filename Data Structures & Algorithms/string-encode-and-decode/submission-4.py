class Solution:

    def encode(self, strs: List[str]) -> str:
        parts = []
        for i in range(len(strs)):
            ch = strs[i]
            parts.append(str(len(ch)) + '#' + ch)
        return "".join(parts)
            
    def decode(self, s: str) -> List[str]:
        res = []
        i = 0

        while i < len(s):
            j = i
            while s[j] != '#':
                j += 1

            length = int(s[i:j])

            start = j + 1
            res.append(s[start: start + length])

            i = start + length
        return res