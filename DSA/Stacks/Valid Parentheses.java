public boolean isValid(String s) 
{
    Stack<Character> stack = new Stack<Character>(); 
    for (char c : s.toCharArray())                                           // loop through each character in the string
    { 
        if (c == '(')
            stack.push(')');                    
        else if (c == '{') 
            stack.push('}');                  
        else if (c == '[') 
            stack.push(']'); 
        else if (stack.isEmpty() || stack.pop() != c)                         // if the character is a closing bracket
                                                                  // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                                                                  // does not match the closing bracket
        return false;
    }
    // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
    // so the string is valid, otherwise, there are unmatched opening brackets, so return false
    return stack.isEmpty();
}
