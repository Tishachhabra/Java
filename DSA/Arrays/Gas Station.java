//Bruteforce : Nested loop - outer track start index inner will traverse stations from there circularly
//Best O(n):1 loop finding +ve balance and deficit whenever bal<0 then startindex++ , bal=0 and def+=bal. At last will check whether bal can overcome def by bal+def<=0

//O(n^2)
public int startStation(int[] gas, int[] cost) 
{
    for(int i=0;i<gas.length;i++)
    {
        int cnt=1,cur=0;
        for(int j=i;cnt<=gas.length;cnt++,j=j%gas.length)
        {
            cur+=gas[j];
            cur-=cost[j];
            if(cur<0)
            break;
        }
        if(cnt>gas.length)
        return i;
    }
    return -1;
}

//O(n)
public int startStation(int[] gas, int[] cost) 
{
        int n = gas.length;
        for(int i = 0; i < n; i++) 
        {
            int cur = 0, j = 0;
            while(j < n) 
            {
                int idx = (i + j) % n;
                cur += gas[idx] - cost[idx];
                if(cur < 0)
                    break;
                j++;
            }
            if(j == n)
                return i;
        }
        return -1;
  }
