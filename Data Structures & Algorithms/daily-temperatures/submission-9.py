class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        s = deque()
        res = [0] * len(temperatures)
 
        for i in range(len(temperatures)):
            while s and temperatures[s[-1]] < temperatures[i]:
                prevIdx = s.pop()
                res[prevIdx] = i - prevIdx
            s.append(i)
        
        return res
        


        
