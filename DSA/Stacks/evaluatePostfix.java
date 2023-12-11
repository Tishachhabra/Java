// Traverse expression, push operands(digits) in stack, if operator come + push two operands frm stack

public static int evaluatePostFix(String s)
    {
        Stack<Integer> stack=new Stack<>();
        int num1;
        int num2;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            stack.push(ch-'0');
            else
            {
                num1=stack.pop();
                    num2=stack.pop();
                switch(ch)
                {
                    case '*' : stack.push(num2*num1);
                            break;
                    case '/' :  stack.push(num2/num1);
                            break;
                    case '+' : stack.push(num2+num1);
                            break;
                    case '-' : stack.push(num2-num1);
                            break;
                }
            }
        }
      return stack.pop();   
    }
