/* 
Link - https://leetcode.com/problems/combinations/solutions/3845227/2-methods-backtracking-recursion-video-c-java-python/

arr[] ---> Input Array
ans[] ---> Temporary array to store current combination
start & end ---> Starting and Ending indexes in arr[]
index ---> Current index in ans[]
r ---> Size of a combination to be printed 
*/

//Use backtracking - Time complexity will be the order of depth of tree or O(n-r) 

void combination(int arr[], int ans[], int start,int end, int index, int r)
{
	if (index == r)                                                       //base case ; combination ready
	{
		for (int j=0; j<r; j++)
			{ System.out.print(ans[j]+" "); }
		System.out.println("");
		return;
	}

	for (int i=start; i<=end && end-i+1 >= r-index; i++)                 // replace ans[index] with all possible elements, condition : end-i+1 >= r-index
								  	     //make sure that no. of elements remaining to be traversed can make required combo
	{
		ans[index] = arr[i];
		combination(arr, ans, i+1, end, index+1, r);
	}
}
