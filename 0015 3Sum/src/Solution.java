import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> solution = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) { // can do - 2
            int inum = nums[i];
            if (inum > 0) {
                break;
            }
            int j = i + 1;
            int k = length - 1;
            while (j < k) {
                int total = inum + nums[j] + nums[k];
                if (total == 0) {
                    List<Integer> oneSolution = new ArrayList<>();
                    oneSolution.add(inum);
                    oneSolution.add(nums[j]);
                    oneSolution.add(nums[k]);
                    solution.add(oneSolution);
                }
                if (total > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        List<List<Integer>> realsol = new ArrayList<>();
        for (List<Integer> set : solution) {
            realsol.add(set);
        }
        return realsol;
    }
}
