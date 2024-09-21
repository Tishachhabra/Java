// trim+sign check with isNeg boolean + traverse until non-digit +update res with digit only if not int overflown

class Solution {
    public int myAtoi(String s) 
    {
        s=s.trim();
        if(s.length()==0)
        return 0;
        boolean neg=false;
        int ans=0,i=0;
        if (s.charAt(0) == '-') 
        {
            neg = true;
            ++i;
        } 
        else if (s.charAt(0) == '+')
        ++i;
        
        while (i < s.length() && Character.isDigit(s.charAt(i))) 
        {
            int digit = s.charAt(i) - '0';
          // to avoid integer overflow
          if (ans > (Integer.MAX_VALUE / 10) || (ans == (Integer.MAX_VALUE / 10) && digit > 7))
          return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
          
          ans = (ans * 10) + digit;
          ++i;
        }
      
    return neg ? -ans : ans;
    }
}
