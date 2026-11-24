class Solution:

    def encode(self, strs: List[str]) -> str:
        res = []
        for i in range(len(strs)):
            ch = strs[i]
            res.append(str(len(ch))+ "#"+ ch)
        return "".join(res)

    def decode(self, s: str) -> List[str]:
        ans = []
        i = 0
        while i < len(s):
            j = i
            while s[j] != "#":
                j += 1
            
            start = j + 1
            end = start + int(s[i:j])

            word = s[start:end]
            ans.append(word)
            i = end

        return ans