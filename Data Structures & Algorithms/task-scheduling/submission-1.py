class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        # so the Counter thing is like a function which we call if we want to know the no of counts means A: 3 or X: 2 Y : 2
        maxheap = []
        for count in count.values():
            heapq.heappush(maxheap, -(count))

        cooldown = deque()
        time = 0

        while maxheap or cooldown:
            if cooldown and cooldown[0][0] <= time:
                available_count, remaining_count = cooldown.popleft()
                heapq.heappush(maxheap, remaining_count)
            
            if maxheap:
                remaining_count = heapq.heappop(maxheap)
                remaining_count += 1
                if remaining_count < 0:
                    available_time = time + n + 1
                    cooldown.append((available_time, remaining_count))
            time += 1
        return time





