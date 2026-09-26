class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int[][] cars = new int[n][2];

        // Store position and speed
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort closest to target first
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double fleetTime = 0;

        for (int i = 0; i < n; i++) {

            double time =
                (double)(target - cars[i][0]) / cars[i][1];

            // This car cannot catch the fleet ahead
            if (time > fleetTime) {
                fleets++;
                fleetTime = time;
            }

            // If time <= fleetTime,
            // it catches the fleet ahead → same fleet
        }

        return fleets;
    }
}