// Method 1 ) String bnado sbko + sort + again convert to integer array
// 2) start with cur as 1 + loop for all nums till n +add to anslist+if cur*10 under n then update cur else check if need to begin new digit or continue incrementing by 1


class Solution {
    public List<Integer> lexicalOrder(int n) {
    List<Integer> ans = new  ArrayList<>();
    int curr = 1;                                             //start with 1 
    for(int i=1; i<=n; i++)                                   // all nos. ensure
    {
      ans.add(curr);                                        
      if(curr*10<=n)                                          // if current's association is under n then update cur
      curr = curr*10;
      else      
      {
        while(curr%10==9 || curr>=n)                 // need to change digit (when cur is 19/29.. or n is only 25 and cur is 25 nowthen cur should be 3 next)
        {
          curr = curr/10;                            //extract first digit
        } 
        curr += 1;                                   // to next number
      }
    } 
    return ans;

    }
}
