/*
Link - https://leetcode.com/problems/product-of-array-except-self/submissions/
*/

//Naive-Double loop multiply all except self , Time : O(n^2)

//Division by whole product , Time : O(n) , Prblm- Division by 0 element
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        int pro = 1;
        for(int i : nums) {
            pro *= i;
        }
        
        for(int i = 0; i < n; i++) {
            ans[i] = pro / nums[i];
        }
        return ans;
    }
}

//Best- Prefix-Suffix prod in original array , Time : O(n) , Space : O(1)
public int[] productExceptSelf(int[] nums) 
{
      int n = nums.length;
      int ans[] = new int[n];
      Arrays.fill(ans, 1);
      int curr = 1; 
      for(int i = 0; i < n; i++)                           //Prefix prod      
      {
          ans[i] *= curr;
          curr *= nums[i];
      }
      curr = 1;
      for(int i = n - 1; i >= 0; i--)                      //Suffix Prod
      {
          ans[i] *= curr;
          curr *= nums[i];
      }
      return ans;
}
