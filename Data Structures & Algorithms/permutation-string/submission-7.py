class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        arr = [0] * 26
        for i in range(len(s1)):
            ch = s1[i]
            idx = ord(ch) - ord('a')
            arr[idx] += 1

        wind = [0] * 26
        left = 0

        for right in range(len(s2)):
            ch = s2[right]
            idxr = ord(ch) - ord('a')
            wind[idxr] += 1

            if left < right and right - left + 1 > len(s1):
                leftch = s2[left]
                leftidx = ord(leftch) - ord('a')
                wind[leftidx] -= 1
                left += 1
            
            if right - left + 1 == len(s1) and wind == arr:
                return True
        return False
                