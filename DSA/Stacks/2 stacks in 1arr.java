class twoStacks 
{    
    private int[] stack;
    private int left;
    private int right;
    
    twoStacks() 
  {
        stack = new int[100];
        left = -1;
        right = 100;
    }
    //Function to push an integer into the stack1.
    void push1(int x) {
        if(left < right - 1)
            stack[++left] = x;
    }
    //Function to push an integer into the stack2.
    void push2(int x) {
       if(left < right - 1)
            stack[--right] = x;
    }
    //Function to remove an element from top of the stack1.
    int pop1() {
        if(left >= 0)
            return stack[left--];
            
        return -1;
    }
    //Function to remove an element from top of the stack2.
    int pop2() 
  {
        if(right < stack.length)
            return stack[right++];
            
        return -1;
    }
}
