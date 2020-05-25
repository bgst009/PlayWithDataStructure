package leetcode;

/**
 * @author yin_zhong_en
 * @version 1.0.0
 * @ClassName Solution.java
 * @createTime 2020年05月25日 16:02:00
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = delNode.next;
        }
        if(head==null){
            return head;
        }
        ListNode prev = head;
        while (prev.next!=null){
            if(prev.next.val==val){
                prev.next=prev.next.next;
            }else {
                prev=prev.next;
            }
        }
        return head;
    }
}
