//Sort + extract - O(nlogn)

// Use priority queue as max heap +with custom comparator + add all elements + remove (k-1) elements then by peek() =answer 
// - O(n+(k-1)logn)

    public static int findKthLargest(int[] nums, int k) 
  {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());          // also (a,b)=>b-a
        // Add all elements of the array into the max-heap
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        // Remove the first (k-1) largest elements from the heap
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        
        // The root of the heap now contains the kth largest element
        return maxHeap.peek();
  }
