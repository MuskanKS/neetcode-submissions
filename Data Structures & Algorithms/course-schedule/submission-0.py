class Solution:
    def canFinish(self, numCourses: int, prerequisites: list[list[int]]) -> bool:
        adj = [[] for _ in range(numCourses)]
        indegree = [0] * numCourses

        for a, b in prerequisites:
            adj[b].append(a)     #means that ki b ko a se pehle finish karna h 
            indegree[a] += 1

        q = deque()
        for i in range(numCourses):
            if indegree[i] == 0:
                q.append(i)

        completed = 0       #to keep track ki kitne courses khatam ho gae h
        while q:
            curr = q.popleft()
            completed += 1
            for neigh in adj[curr]:
                indegree[neigh] -= 1
                if indegree[neigh] == 0:
                    q.append(neigh)

        return completed == numCourses