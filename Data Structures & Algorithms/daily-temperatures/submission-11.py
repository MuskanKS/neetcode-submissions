class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        # optimise using stack
        res = [0] * len(temperatures)

        dq = deque()

        for i in range(len(temperatures)):
            while dq and temperatures[dq[-1]] < temperatures[i]:
                # idhar while lagaenge ki jab tak aese hai tab tak pop karo aur fill karo 
                idx = dq.pop()
                res[idx] = i - idx
            dq.append(i)

        return res
