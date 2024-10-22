/* Approach - prefixsum in hashmap
  Transform array elements : if x then +1 ; if y then -1 else 0 for all. This way any subarray with 0 sum is to be counted.
  */
public static int countSubArrays(int[] arr, int x, int y) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int count = 0;
        int prefixSum = 0;

        // Initialize the map with prefix sum 0 occurring once ; to match further prefixsums
        prefixMap.put(0, 1);

        for (int num : arr) {
            // Transform the array: +1 for x, -1 for y, 0 for others
            if (num == x) {
                prefixSum += 1;
            } else if (num == y) {
                prefixSum -= 1;
            }

            // Check if the current prefixSum has been seen before ; if yes update count since middles ones are potential ans
            if (prefixMap.containsKey(prefixSum)) {
                count += prefixMap.get(prefixSum);
            }

            // Update the map with the current prefix sum frequency
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
