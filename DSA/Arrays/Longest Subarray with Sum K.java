//Reverse engineering
// Best O(n) - 1 loop traversal. At every index i calc prefixsum & check if prefixsum==k (potential ans). See remaining subarray (prefixsum-k) exists in map+then bich ki subarray is potential ans. Then map me add curr prefixsum only when it is not there.

public static int lenOfLongSubarr (int a[], int n, int k) 
{
        Map<Long, Integer> preSumMap = new HashMap<>();
        long sum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            //calculate the prefix sum till index i:
            sum += a[i];

            // potential ans ; subarray from 0 till i
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            long rem = sum - k;

            //if rem is in map then subarr exists in middle
            if (preSumMap.containsKey(rem)) {
                int len = i - preSumMap.get(rem);
                maxLen = Math.max(maxLen, len);
            }

            // put this prefixsum only when it is not there ; (to get longest subarr)
            if (!preSumMap.containsKey(sum)) {
                preSumMap.put(sum, i);
            }
        }

        return maxLen;
        
    }
