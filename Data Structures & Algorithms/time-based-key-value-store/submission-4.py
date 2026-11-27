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

        value = self.hm[key]
        left = 0
        right = len(value) - 1
        ans = ""

        while left <= right:
            mid = (right + left) // 2
            saved_timestamp, saved_value = value[mid]
            if saved_timestamp <= timestamp:
                ans = saved_value
                left = mid + 1
            else:
                right = mid - 1
        return ans
