//Sort+meet-in-middle for 2Sum +check for potential ans
static int threeSumClosest(int[] arr, int target) 
    {
        Arrays.sort(arr);
    long closestSum = Integer.MAX_VALUE;          //ans
    for (int i = 0; i < arr.length - 2; i++) 
    {
        int ptr1 = i + 1, ptr2 = arr.length- 1;
        while (ptr1 < ptr2)
        {
            long sum = arr[i] + arr[ptr1] + arr[ptr2];
 
            // If the sum is more closer than the current closest sum OR if it has same distance from target but its ahead
            if ((Math.abs(target - sum) < Math.abs(target - closestSum)) || ((Math.abs(target - sum) == Math.abs(target - closestSum)) && sum>closestSum) )
            {
                closestSum = sum;
            }
            if (sum > target)         //meet-in-middle
            {
                ptr2--;
            }
            else
            {
                ptr1++;
            }
        }
    }
 
    // Return the closest sum found
    return (int)closestSum;
    }
}
