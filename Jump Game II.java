//Greedy Method Approach
class Solution {

    // TC : O(n)
    // SC : O(1)
    public int jump(int[] nums) {
        int level =0; //jumps that we take
        int divider = 0; //index
        int maxReachableIndex = 0;
        for(int i=0;i<nums.length;i++){
            if(i> divider){  //if reached the divider value
                level++;
                divider = maxReachableIndex; //update it to maxReachableIndex
            }
            maxReachableIndex = Math.max(maxReachableIndex, i +nums[i]); //otherwise update it to this
        }

        return level;
    }

}
