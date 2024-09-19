// Left-right recursion on encountering each oper+from res of both side nested loop for all combo+base case expression integer add in res

class Solution {
    public List<Integer> diffWaysToCompute(String expression) 
  {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < expression.length(); ++i) 
        {
            char oper = expression.charAt(i);
            if (oper == '+' || oper == '-' || oper == '*') 
            {
                List<Integer> s1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i + 1));
                for (int a : s1) 
                {
                    for (int b : s2)                                     //for each combo compute and add in result
                    {
                        if (oper == '+') res.add(a + b);
                        else if (oper == '-') res.add(a - b);
                        else if (oper == '*') res.add(a * b);
                    }
                }
            }
        }
        if (res.isEmpty()) res.add(Integer.parseInt(expression));        //base case, add the only integer in substring
        return res;
    }
}
