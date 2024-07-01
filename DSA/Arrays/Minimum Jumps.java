/*
Link- https://www.geeksforgeeks.org/problems/minimum-number-of-jumps-1587115620/1

O(n)
*/

static int minJumps(int[] arr, int n) 
    {
        if (n <= 1) // If array has 1 or no elements
            return 0;
        
        if (arr[0] == 0) // If the first element is 0, end cannot be reached
            return -1;

        int jumps = 1; // Initializing jumps to 1 since we assume the first jump from the start
        int maxReach = arr[0]; // The maximum index we can reach
        int steps = arr[0]; // Steps we can still take within the current jump

        for (int i = 1; i < n; i++) 
        {
            if (i == n - 1) // If we've reached the end of the array
                return jumps;

            maxReach = Math.max(maxReach, i + arr[i]); // Update maxReach
            steps--; // We use a step to get to the current index

            if (steps == 0) 
            { // No more steps left
                jumps++; // We need another jump
                if (i >= maxReach) // If the current index is out of max reach
                    return -1;
                steps = maxReach - i; // Reinitialize steps to the amount of steps to reach maxReach
            }
        }
        return -1; 
}
