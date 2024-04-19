/*
Link - https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
*/

// Use auxiliay array of mods and hashmap - O(n)
int longSubarrWthSumDivByK(int arr[], int n, int k)
{
    HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();               //store frst occurrences of mods
    int mod_arr[] = new int[n];                                                  //store (arr[0]....arr[i]) % k , isi se subarrays decide
    int max_len = 0;
    int curr_sum = 0;
    
    for (int i = 0; i < n; i++) 
    {
        curr_sum += arr[i];
        mod_arr[i] = ((curr_sum % k) + k) % k;                                //sum may be -ve so 2 modulo

        if (mod_arr[i] == 0)
            max_len = i + 1;

        else if (map.containsKey(mod_arr[i]) == false)                       //if mod value hasnt come yet, will store only frst occurence to make longer subarr
            map.put(mod_arr[i], i);

        else
            if (max_len < (i - map.get(mod_arr[i])))                        //compare for no of elements in subarray with max_len so far
            max_len = i - map.get(mod_arr[i]);
    }
    return max_len;
}
