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
        left  = 0
        value = self.hm[key]
        ans = ""
        right = len(value) - 1

        while left <= right:
            mid = (left + right) // 2
            saved_time, saved_vale = value[mid]
            if saved_time <= timestamp:
                ans = saved_vale
                left = mid + 1
            else:
                right = mid - 1

        return ans