// Bruteforce - TO use nested loops
// Better- Sort then check for every potential seq length - O(nlogn+n)

public int longestConsecutive(int[] nums) 
{
    if(nums.length==0)
    return 0;
    Arrays.sort(nums);
    int n=nums[0];
    int max=1,cnt=1;
    for(int i=1;i<nums.length;i++)
    {
        if(nums[i]==n)
        continue;
        else if(nums[i]==n+1)          //consecutive ele
        {
            cnt++;
            n=nums[i];
        }
        else                          //diff starting pt      
        {
            max=Math.max(max,cnt);
            cnt=1;
            n=nums[i];
        }
    }
    max=Math.max(max,cnt);
    return max;
}

// Best - Use set to store all + find every potential starting point of seq ( x-1 shouldnt be in set) + for each starting pt run while if their consecutives are in set and update current count then maxsofar  

public static int longestSuccessiveElements(int[] a) 
{
    int n = a.length;
    if (n == 0)
        return 0;

    int longest = 1;
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++)                      // put all the array elements into set
        set.add(a[i]);

    for (int it : set) 
    {
        if (!set.contains(it - 1))                   //find strting pt
        {
            int cnt = 1;
            int x = it;
            while (set.contains(x + 1))               // find consecutive numbers
            {
                x = x + 1;
                cnt = cnt + 1;
            }
            longest = Math.max(longest, cnt);          //update max with current cnt if better
        }
    }
    return longest;
}


