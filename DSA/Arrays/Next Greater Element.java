//store bigger right elem in stack 
public ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) //top bigger than curr ; if not delete smallers till find bigger
            {
                st.pop();
            }
            if (st.isEmpty()) // no one bigger than itself
            {
                res.add(0, -1);
            } 
            else 
            {
                res.add(0, st.peek());  //next bigger add
            }
            st.push(arr[i]);
        }
        
        return res;
    }
