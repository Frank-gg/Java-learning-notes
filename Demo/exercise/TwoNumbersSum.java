package Exercise;

import java.util.HashMap;

/*
    题目：给定一个整数数组 nums 和一个整数目标值 target，
         在该数组中找出和为目标值 target  的那两个整数，
         并返回它们的数组下标。
*/

public class TwoNumbersSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        twoSum(nums, target);
    }

    public static int[] twoSum(int[] nums, int target){

        HashMap<Integer, Integer> hashtable = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; ++i) {
            if(hashtable.containsKey(target - nums[i])){
                return new int[] {hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
