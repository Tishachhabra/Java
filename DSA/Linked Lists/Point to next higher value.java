/*
Link - https://www.geeksforgeeks.org/point-to-next-higher-value-node-in-a-linked-list-with-an-arbitrary-pointer/
*/

//Bruteforce - Traverse each node and find higher value against it - O(n^2)
//Better - Merge Sort by arbitrary pointer

// Java program to populate arbit pointers 
// to next higher value using merge sort

class LinkedList
{
	static Node head;
	static class Node
	{
		int data;
		Node next, arbit;
		Node(int data) 
		{
			this.data = data;
			next = null;
			arbit = null;
		}
	}

	// This function populates arbit pointer in every node to the 
	// next higher value. And returns pointer to the node with 
	// minimum value
	private Node populateArbit(Node start)
	{
		Node temp = start;
		while (temp != null)
		{
			temp.arbit = temp.next;
			temp = temp.next;
		}

		// Do merge sort for arbitrary pointers and
		// return head of arbitrary pointer linked list
		return MergeSort(start);
	}

	/* sorts the linked list formed by arbit pointers 
	(does not change next pointer or data) */
	private Node MergeSort(Node start)
	{
		if (start == null || start.arbit == null)
		{
			return start;
		}

		/* Split head into 'middle' and 'nextofmiddle' sublists */
		Node middle = getMiddle(start);
		Node nextofmiddle = middle.arbit;
		middle.arbit = null;

		Node left = MergeSort(start);
		Node right = MergeSort(nextofmiddle);

		/* answer = merge the two sorted lists together */
		Node sortedlist = SortedMerge(left, right);

		return sortedlist;
	}

	private Node getMiddle(Node source)
	{
		// Base case
		if (source == null)
			return source;
		Node fastptr = source.arbit;
		Node slowptr = source;

		// Move fastptr by two and slow ptr by one 
		// Finally slowptr will point to middle node
		while (fastptr != null)
		{
			fastptr = fastptr.arbit;
			if (fastptr != null)
			{
				slowptr = slowptr.arbit;
				fastptr = fastptr.arbit;
			}
		}
		return slowptr;
	}

	private Node SortedMerge(Node a, Node b)
	{
		Node result = null;

		/* Base cases */
		if (a == null)
			return b;
		else if (b == null)
			return a;

		/* Pick either a or b, and recur */
		if (a.data <= b.data)
		{
			result = a;
			result.arbit = SortedMerge(a.arbit, b);
		}
		else
		{
			result = b;
			result.arbit = SortedMerge(a, b.arbit);
		}
		return result;
  }
