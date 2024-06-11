/*
Link- https://www.naukri.com/code360/problem-of-the-day/easy

Approach-we can find atmost k distinct integers subarrays by sliding window (r-l+1) This will calculate all subarrays from left pointer to right ending at right. To find exact k distint we have to do atmostK(arr,k)-atmostK(arr,k-1). 
*/

public static int atmost(int [] arr,int k)
    {
        HashMap<Integer,Integer> map=new HashMap<>();              //store freq of char
        int l=0;
        int r=0;
        int count=0;
        while(r<arr.length)
        {
            map.put(arr[r],map.getOrDefault(arr[r], 0)+1);          //ri8 character freq inc
            while(map.size()>k)                                      //more than k char stored
            {
                map.put(arr[l],map.get(arr[l])-1);                    //dec left char freq          
                if(map.get(arr[l])==0)                               //if its 0 then remove from map
                map.remove(arr[l]);
                l++;
            }
            count+=r-l+1;                                          //count subarrays from left to ri8 -> ending at right
            r++;
        }
        return count;
    }
    public static int goodSubarrays(int arr[], int n,int b) 
    {
        return (atmost(arr,b)-atmost(arr,b-1));                      //will give exactly k distinct subarrays
    }
