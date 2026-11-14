class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        dq = deque()

        for i in range(len(temperatures)):
            while dq and temperatures[i] > temperatures[dq[-1]]:
                prev = dq.pop()
                res[prev] = i - prev
            dq.append(i)

        return res