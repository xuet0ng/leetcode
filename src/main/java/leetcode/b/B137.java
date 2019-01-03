package leetcode.b;

public class B137 {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
     * <p>
     * 说明：
     * <p>
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     * <p>
     * 示例 1:
     * <p>
     * 输入: [2,2,3,2]
     * 输出: 3
     * 示例 2:
     * <p>
     * 输入: [0,1,0,1,0,1,99]
     * 输出: 99
     */
    class Solution {
        public int singleNumber(int[] nums) {
            for (int i = 0; i < nums.length; ) {
                int now = nums[i];
                int copyIndex = i;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == now) {
                        exchange(nums, ++copyIndex, j);
                    }
                }
                if (copyIndex == i) {
                    return now;
                }
                i = copyIndex + 1;
            }
            return 0;
        }

        private void exchange(int[] nums, int aIndex, int bIndex) {
            int mid = nums[aIndex];
            nums[aIndex] = nums[bIndex];
            nums[bIndex] = mid;
        }
    }

    public static final void main(String[] args) {
        B137 b137 = new B137();
        Solution solution = b137.new Solution();
        int[] a = {99};
        System.out.println(solution.singleNumber(a));
    }

}
