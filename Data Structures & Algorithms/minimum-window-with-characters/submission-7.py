class Solution:
    def minWindow(self, s: str, t: str) -> str:
        arr = [0] * 128
        for i in range(len(t)):
            ch = t[i]
            idx = ord(ch)
            arr[idx] += 1
        
        require = 0
        for i in range(128):
            if arr[i] > 0:
                require += 1
            
        have = 0
        left = 0
        minLeft = 0
        minLen = float("inf")
        wind = [0] * 128

        for right in range(len(s)):
            ch = s[right]
            idxr = ord(ch)
            wind[idxr] += 1
            if arr[idxr] > 0 and wind[idxr] == arr[idxr]:
                have += 1
            while have == require:
                if right - left + 1 < minLen:
                    minLen = right - left + 1
                    minLeft = left
                leftchar = s[left]
                leftidx = ord(leftchar)
                wind[leftidx] -= 1
                if arr[leftidx] > 0 and arr[leftidx] > wind[leftidx]:
                    have -= 1
                left += 1

        if minLen ==  float("inf"):
            return ""
        return s[minLeft: minLeft + minLen]
            