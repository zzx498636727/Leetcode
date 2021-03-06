import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Zexuan on 2017/2/27.
 */
public class Subsets {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        subsetsHelper(result, list, nums, 0);
        return result;
    }

    private void subsetsHelper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, int[] nums, int pos) {

        /* First add the list generated by last call of subsetsHelper
         */

        result.add(new ArrayList<Integer>(list));

        for (int i = pos; i < nums.length; i++) {
            /* Check if the next number is a duplicate
             */
            if (i > pos && nums[i] == nums[i - 1]) {
                continue;
            }
            /* In the current list, add more number to search all possible combination
             */
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            /* Remember to remove the element added so that we can trace back
             */
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[3];
        nums[0] = 4;
        nums[1] = 1;
        nums[2] = 0;
        Subsets sb = new Subsets();
        System.out.print(sb.subsets(nums));

    }
}
