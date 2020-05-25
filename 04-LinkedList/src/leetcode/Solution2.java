package leetcode;

/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Solution.java
 * @createTime 2020年05月25日 16:02:00
 *
 * 虚拟头节点简化代码
 */
public class Solution2 {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}
