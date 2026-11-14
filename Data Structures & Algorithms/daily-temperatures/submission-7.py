class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        dq = deque()

        for i in range(len(temperatures)):
            while dq and temperatures[i] > temperatures[dq[-1]]:
                prevIdx = dq.pop()
                res[prevIdx] = i - prevIdx
            dq.append(i)

        return res