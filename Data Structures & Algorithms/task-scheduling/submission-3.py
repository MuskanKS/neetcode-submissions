class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hm = {}

        for i in range(len(tasks)):
            hm[tasks[i]] = hm.get(tasks[i], 0) + 1

        maxh = []

        for count in hm.values():
            heapq.heappush(maxh, -count)

        cooldown = deque()
        time = 0

        while maxh or cooldown:
            if cooldown and cooldown[0][0] <= time:
                available_time, remaining_cost = cooldown.popleft()
                heapq.heappush(maxh, remaining_cost)

            if maxh:
                remaining_cost = heapq.heappop(maxh)
                remaining_cost += 1
                if remaining_cost < 0:
                    available_time = time + 1 + n
                    cooldown.append((available_time, remaining_cost))
            time += 1
        return time
