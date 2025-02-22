/* Track unmatched parentheses (either ( or ) )indices in stack. 
When ( push index,when ) then pop ; if not empty calc maxLength , if empty push cur index (since it cannot be matched  */

class Solution {
    static int maxLength(String s) 
  {
        Stack<Integer> stack=new Stack<>();
        stack.push(-1);                          //imp for maintaining unmatched index
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
                stack.push(i);
             else
            {
                stack.pop();
                if(!stack.isEmpty())
                   result=Math.max(result,i-stack.peek()); 
                else
                    stack.push(i);                // if closing ) cannot be matched
            }
        }
        return result;
    }
}
