class TimeMap:

    def __init__(self):
        # create a hm
        self.hm = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        # so we did this because hume na timestamp aur value chahiye
        if key not in self.hm:
            self.hm[key] = []
        self.hm[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.hm:
            return ""
        # now we will check 
        value = self.hm[key]
        ans = ""
        

        left = 0
        right = len(value) - 1

        while left <= right:
            mid = (left + right) // 2
            saved_timestamp, saved_value = value[mid]
            if saved_timestamp <= timestamp:
                ans = saved_value
                left = mid + 1
            else:
                right = mid - 1

        return ans
