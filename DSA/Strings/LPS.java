/* LPS is pi table used in KMP (string matching) algo. It is a dp array working bottom to top. lps[i] represents lps of str[0...i]. lps[last] gives ans=longest length of prefix which is also suffix.
*/
class Solution {
    int lps(String s) 
  {
        int n = s.length();
        int[] lps = new int[n];
        int i = 0, j =1;                    //j is for traversing through string
        lps[0] = 0;
        
        while(j <n){
            if(s.charAt(i) == s.charAt(j)){
                lps[j] = i + 1;            //updated lps[j] to signify that until here (s[0...j])lps length is lps[j] stored; 
                i++;
                j++;
                
            }else{
                if(i == 0){
                    lps[j] = 0;
                    j++;
                }else{
                    i = lps[i-1];
                }
            }
        }
        
        return lps[n-1];
        
    }
}
