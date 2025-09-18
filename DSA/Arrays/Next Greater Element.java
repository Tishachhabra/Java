//store bigger right elem in stack 
public ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i])                       // pop out smaller numbers which appeared in right till found bigger or stack is empty
            {
                st.pop();
            }
            if (st.isEmpty())                                            // stack got empty by popping / i is at last index == no element in right exist which is bigger than cur
            {
                res.add(0, -1);
            } 
            else 
            {
                res.add(0, st.peek());                                  //next bigger left in stack add
            }
            st.push(arr[i]);
        }
        
        return res;
    }
