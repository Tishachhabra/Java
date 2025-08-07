// Convert all times to seconds, check diff & wrap around diff
// https://www.geeksforgeeks.org/problems/difference-check/1
//Bruteforce (n^2): Convert all to standard seconds format > nested loop compare all pairs with minDiff(ans) > check diff and wrap around diff (86400-diff)
public class MinTimeDifference {

    public static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }

    public static int findMinDifferenceBrute(String[] arr) {
        int n = arr.length;
        int[] seconds = new int[n];
        
        for (int i = 0; i < n; i++) {
            seconds[i] = timeToSeconds(arr[i]);
        }

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(seconds[i] - seconds[j]);
                minDiff = Math.min(minDiff, Math.min(diff, 86400 - diff)); // check wrap-around
            }
        }

        return minDiff;
    }
}

//Best (nlogn):  Convert all to standard seconds format > sort > check adjacent pairs > in last check circular wrap time = 86400-arr[last]+arr[first]

public class MinTimeDifference {

    public static int timeToSeconds(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        int s = Integer.parseInt(parts[2]);
        return h * 3600 + m * 60 + s;
    }

    public static int findMinDifferenceOptimized(String[] arr) {
        int n = arr.length;
        int[] seconds = new int[n];

        for (int i = 0; i < n; i++) {
            seconds[i] = timeToSeconds(arr[i]);
        }

        Arrays.sort(seconds);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int diff = seconds[i] - seconds[i - 1];
            minDiff = Math.min(minDiff, diff);
        }

        // Wrap-around difference
        int wrapDiff = 86400 - seconds[n - 1] + seconds[0];
        minDiff = Math.min(minDiff, wrapDiff);

        return minDiff;
    }
}

