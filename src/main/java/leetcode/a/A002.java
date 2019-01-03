package leetcode.a;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class A002 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return rough(l1, l2);
        }

        /**
         * 先来一个暴力的...能解决问题的...
         */
        private ListNode rough(ListNode l1, ListNode l2) {
            ListNode resRoot;
            ListNode currentResNode;
            ListNode currentL1 = l1;
            ListNode currentL2 = l2;
            // 进位
            int additional;
            int resVal;
            additional = roughSumNode(currentL1, currentL2, 0) / 10;
            resVal = roughSumNode(currentL1, currentL2, 0) % 10;
            resRoot = new ListNode(resVal);
            currentResNode = resRoot;
            currentL1 = getNextFromNode(currentL1);
            currentL2 = getNextFromNode(currentL2);
            while (currentL2 != null || currentL1 != null) {
                int sum = roughSumNode(currentL1, currentL2, additional);
                resVal = sum % 10;
                additional = sum / 10;
                currentResNode.next = new ListNode(resVal);
                currentL1 = getNextFromNode(currentL1);
                currentL2 = getNextFromNode(currentL2);
                currentResNode = getNextFromNode(currentResNode);
            }
            if (additional != 0) {
                currentResNode.next = new ListNode(additional);
            }
            return resRoot;
        }

        private int roughSumNode(ListNode currentL1, ListNode currentL2, int additional) {
            return getVarFromNode(currentL1) + getVarFromNode(currentL2) + additional;
        }

        private int getVarFromNode(ListNode node) {
            return node != null ? node.val : 0;
        }

        private ListNode getNextFromNode(ListNode node) {
            return node != null ? node.next : null;
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }
    }

}
