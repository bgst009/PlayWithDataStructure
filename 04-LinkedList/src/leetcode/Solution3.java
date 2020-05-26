package leetcode;

/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Solution3.java
 * @createTime 2020年05月26日 09:11:00
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {
        /**
         * 最小问题的处理
         */
        if (head == null) {
            return null;
        }
        /**
         * 宏观问题的处理
         */
        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6);
        System.out.println(res);
    }
}
