class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # so first we will know the frequecny of each and every task for that we will use a counter
        count = Counter(tasks)
        maxheap = []

        for count in count.values():
            heapq.heappush(maxheap, -count)

        cooldown = deque()
        time = 0

        while maxheap or cooldown:
            if cooldown and cooldown[0][0] <= time:
                available_time, remaining_count = cooldown.popleft()
                heapq.heappush(maxheap, remaining_count)
            
            if maxheap:
                remaining_count = heapq.heappop(maxheap)
                remaining_count += 1
                if remaining_count < 0:
                    available_time = time + n + 1
                    cooldown.append((available_time, remaining_count))

            time += 1
        
        return time