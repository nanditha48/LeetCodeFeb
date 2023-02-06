//Time: O(n)
//Space: O(n)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int shuffled[] = new int[nums.length]; //shuffled arrays as the nums.length
        for(int i=0; i<n; i++){
            shuffled[2*i] = nums[i]; //index in the shuffled array
            shuffled[2*i + 1] = nums[n+i]; //index for y
        }
        return shuffled;
    }
}
