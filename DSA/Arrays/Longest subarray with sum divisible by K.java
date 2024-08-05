// Use auxiliay array of mods and hashmap - O(n)
// Make aux array for storing remainders of (prefixsum % k) until i 
//After getting current rem + check if 0 then find potential length of subarr + else check map if it doesnt contains then put with i as first occurence + else if map contains then calc length from that occurence till i.

class Solution{
    int longSubarrWthSumDivByK(int arr[], int n, int k)
    {
       
        HashMap<Integer, Integer> map= new HashMap<Integer, Integer>();
        int mod_arr[] = new int[n];                     // 'mod_arr[i]' stores (sum[0..i] % k)
        int max_len = 0;
        int curr_sum = 0;
        
        for (int i = 0; i < n; i++) {
            curr_sum += arr[i];
            mod_arr[i] = ((curr_sum % k) + k) % k;        // as the sum can be negative taking modulo twice
            if (mod_arr[i] == 0)
                max_len = i + 1;

            else if (map.containsKey(mod_arr[i]) == false)    //if not occured until now, store with first occurence
                map.put(mod_arr[i], i);
            else
                if (max_len < (i - map.get(mod_arr[i])))      //from that index till i remainder will be nullified
                max_len = i - map.get(mod_arr[i]);
        }
        return max_len;
    }
 
}

