package leetcode;

import java.util.*;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class A001 {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            return withOneHashTable(nums,target);
        }

        private int[] loop(int[] nums, int target) {
            for (int i = 0; i<nums.length; i++) {
                for (int j =i +1; j< nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] {i,j};
                    }
                }
            }
            return null;
        }

        private int[] withOneHashTable(int[] nums, int target) {
            Map<Integer, Integer> num2Index = new HashMap<Integer, Integer>();
            for (int i=0; i<nums.length; i++) {
                num2Index.put(nums[i], i);
            }
            for (int i=0; i<nums.length; i++) {
                int first = nums[i];
                int second = target - first;
                if (num2Index.containsKey(second) && i != num2Index.get(second)) {
                    return new int[]{i, num2Index.get(second)};
                }
            }
            return null;
        }
    }
}
