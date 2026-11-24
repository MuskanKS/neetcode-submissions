class MinStack:

    def __init__(self):
        self.dq = deque()
        self.mdq = deque()

    def push(self, val: int) -> None:
        self.dq.append(val)
        if not self.mdq:
            self.mdq.append(val)
        else: 
            self.mdq.append(min(val, self.mdq[-1]))


    def pop(self) -> None:
        self.dq.pop()
        self.mdq.pop()
        

    def top(self) -> int:
        return self.dq[-1]
        

    def getMin(self) -> int:
        return self.mdq[-1]
        
