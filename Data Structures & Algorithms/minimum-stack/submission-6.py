class MinStack:

    def __init__(self):
        self.s = []
        self.mins = []

    def push(self, val: int) -> None:
        self.s.append(val)

        if not self.mins:
            self.mins.append(val)
        else:
            self.mins.append(min(val, self.mins[-1])) 

    def pop(self) -> None:
        self.s.pop()
        self.mins.pop()

    def top(self) -> int:
        return self.s[-1]

    def getMin(self) -> int:
        return self.mins[-1]