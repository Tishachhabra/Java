//Approaches:-
//1) Use sort()
//2) Count 0s, 1s and 2s then fill array with them in order
//3) DNF algo - Splitting array into ranges into [0s,1s,unsorted,2s] by [0...low-1] [low....mid-1][mid...high][high+1...]

public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        int temp;

        while(mid <= high){                                // = necessaryu bcoz maybe 2 is in [mid-high] then it has to be placed in right position
            if(nums[mid] == 0){
                temp = nums[mid];
                nums[mid++] = nums[low];                       // mid bhi inc bcoz replace krke 1 hi aega that is also settled on mid
                nums[low++] = temp;
            }else if(nums[mid] == 1){
                mid++;
            }else{
                temp = nums[high];
                nums[high--] = nums[mid];
                nums[mid] = temp;
            }
        }
    }
