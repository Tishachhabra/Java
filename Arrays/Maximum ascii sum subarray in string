/*
Given a string w, integer array b,  character array x and an integer n. n is the size of array b and array x. Find a substring which has the highest sum of ASCII. ASCII values of some characters are redefined. Array b and Array x contain corresponding redefined ASCII values. For each i, b[i] contain redefined ASCII value of character x[i].
*/

public String maxSum(String w,char x[],int b[], int n)
{
     Map<Character, Integer> map = new HashMap<>();
    for (int i=0; i<n; i++) 
    {
        map.put(x[i], b[i]);
    }
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    String max_str="";
    String cur_str="";
    for (int i = 0; i < w.length(); i++) 
    {
        char c=w.charAt(i);
        cur_str+=c;
        currentSum+=map.containsKey(c) ? map.get(c) : (int) c;
        if (currentSum > maxSum) 
        {
            maxSum = currentSum;
            max_str=cur_str;
        }
        
        if (currentSum < 0) 
        {
            currentSum = 0;
            cur_str="";
        }
    }
        return max_str;
}

