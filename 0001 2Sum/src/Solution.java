class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < nums.length - 1; i++) {
            int next = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == next) {
                    int[] returnarray = new int[2];
                    returnarray[0] = i;
                    returnarray[1] = j;
                    return returnarray;
                }
            }
        }
        return null;
    }
}