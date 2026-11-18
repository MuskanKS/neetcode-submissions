class TimeMap:

    def __init__(self):
        self.hm = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.hm:
            self.hm[key] = []
        self.hm[key].append((timestamp, value))
    def get(self, key: str, timestamp: int) -> str:
        if key not in self.hm:
            return ""

        values = self.hm[key]
        left = 0
        right = len(values) -1 
        res = ""

        while left <= right:
            mid = (right + left) // 2
            if values[mid][0] <= timestamp:
                res = values[mid][1]
                left = mid + 1
            else:
                right = mid - 1
        return res