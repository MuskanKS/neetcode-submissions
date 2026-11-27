class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        cars = sorted(zip(position, speed), reverse = True)

        fleet_time = []

        for pos, spd in cars:
            time = (target - pos) / spd
            if not fleet_time or fleet_time[-1] < time:
                fleet_time.append(time)

        return len(fleet_time)