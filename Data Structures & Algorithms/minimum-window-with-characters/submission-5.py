class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = [0] * 128

        for i in range(len(t)):
            ch = t[i]
            need[ord(ch)] += 1

        require = 0
        for i in range(128):
            if need[i] > 0:
                require += 1
        
        have = 0

        low = 0
        high = 0

        minLen = float('inf')
        minLow = 0
        wind = [0] * 128

        while high < len(s):
            ch = s[high]
            idx = ord(ch)
            wind[idx] += 1
            if need[idx] > 0 and wind[idx] == need[idx]:
                have += 1
            
            while have == require:
                if high - low + 1 < minLen:
                    minLen = high - low + 1
                    minLow = low
                removeIdx = ord(s[low])
                wind[removeIdx] -= 1
                if need[removeIdx] > 0 and wind[removeIdx] < need[removeIdx]:
                    have -= 1
                low += 1
            high += 1
        if minLen == float('inf'):
            return ""
        return s[minLow: minLow + minLen]