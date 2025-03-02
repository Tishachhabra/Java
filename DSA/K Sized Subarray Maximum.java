// Bruteforce - Check every subset of k size from left -- O (n*k)
// Priority queue - mantain size of k , add new elem remove prior, save max for cur window

public ArrayList<Integer> maxOfSubarrays(int arr[], int k) 
{
        if (k == 1) 
        {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : arr) {
                list.add(num);
            }
            return list;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<k;i++)
        {
            pq.add(arr[i]);
        }
        ans.add(pq.peek());
        for(int i=1;i<=arr.length-k;i++)
        {
            pq.remove(arr[i-1]);
            pq.add(arr[i+k-1]);
            ans.add(pq.peek());
        }
        return ans; 
}

//Deque- store indices, at front remove out of bound index + from back remove smaller elem + add cur

public ArrayList<Integer> maxOfSubarrays(int arr[], int k) 
{
       if (k == 1) 
       {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : arr)
                list.add(num);
            return list;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) 
        {
            // Remove elements that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) 
                dq.pollFirst();

            // Remove smaller elements from the back
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) 
            {
                dq.pollLast();
            }

            // Add the current element index
            dq.offerLast(i);

            // Add max for current window
            if (i >= k - 1)
                ans.add(arr[dq.peekFirst()]);              
        }
        return ans;
    }
