class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Closest to target first
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        double[] time = new double[n];

        for (int i = 0; i < n; i++) {
            time[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        int fleets = n;

        // Compare every car with the car/fleet ahead
        for (int i = 0; i < n - 1; i++) {

            if (time[i] >= time[i + 1]) {
                // Car behind catches the fleet ahead
                time[i + 1] = time[i];
                fleets--;
            }
        }

        return fleets;
    }
}