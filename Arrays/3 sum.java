/* 
Link - https://leetcode.com/problems/3sum/submissions/1029852181/
*/

//Using Set for removing duplicacy - O(nlogn)+n*m+n
public List<List<Integer>> threeSum(int[] nums) 
{
  Arrays.sort(nums);
  Set<List<Integer>> s = new HashSet<>();
  List<List<Integer>> output = new ArrayList<>();
  for (int i = 0; i < nums.length; i++)                                       //Each element traversal
  {
    int l = i + 1;
    int r = nums.length - 1;
    while (l < r)                                                             //Meet-in-middle algo
    {
      int sum = nums[i] + nums[l] + nums[r];
      if (sum == 0) 
      {
        s.add(Arrays.asList(nums[i], nums[l], nums[r]));                      //if sum of triplet = 0 add to set , will store only unique lists
        l++;
        r--;
      } 
      else if (sum < 0)
          l++;
      else
          r--;
    }
  }
  output.addAll(s);                                                          //Final set to list
  return output;
}


//Without Set - O(nlogn)+n*m    (m less than above in case of duplicacy)
public List<List<Integer>> threeSum(int[] nums) 
{
  List<List<Integer>> ans = new ArrayList<>();
  Arrays.sort(nums);
  for (int i = 0; i < nums.length - 2; i++) 
  {
    if (i > 0 && nums[i] == nums[i - 1])                                    // Skip duplicate elements for i
        continue;

    int l = i + 1;
    int r = nums.length - 1;

    while (l < r) 
    {
      int sum = nums[i] + nums[l] + nums[r];
      if (sum == 0) 
      {
        ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
        while (l < r && nums[l] == nums[l + 1])                         // Skip duplicate elements for l
        {
              l++;
        }
            while (l < r && nums[r] == nums[r - 1])                     // Skip duplicate elements for r
          {
              r--;
          }

          // Move the pointers
          l++;
          r--;
      }
      else if (sum < 0)
          l++;
      else
          r--;
    }
  }
return ans;
}
