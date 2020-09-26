import javax.sql.rowset.serial.SerialArray;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class ArrayMaxSum {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     * <p>
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * <p>
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int val : nums) {
            if (sum > 0)
                sum += val;
            else
                sum = val;
            if (sum > res)
                res = sum;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int len = scan.nextInt();
        int[] b = new int[len];
        for(int i = 0; i < b.length; i++)
            b[i] = scan.nextInt();
        ArrayMaxSum solution = new ArrayMaxSum();
        int maxSubArray = solution.maxSubArray(b);
        System.out.println(maxSubArray);
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        ArrayMaxSum solution = new ArrayMaxSum();
//        int maxSubArray = solution.maxSubArray(nums);
//        System.out.println(maxSubArray);
    }
}
