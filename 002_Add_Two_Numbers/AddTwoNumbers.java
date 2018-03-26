/**
 * Created by jkzhao on 3/26/18.
 */

public class AddTwoNumbers {
    /**
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
       Output: 7 -> 0 -> 8

       time complexity: O(n)
       space complexity: O(n)

     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2; //为了不修改原来的list
        int sum = 0;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            sum /= 10;
        }
        if (sum == 1) { //最后一组加完后，如果sum为1，说明最后一组进位了。比如最后一组为7 + 8 = 15，整除10结果为1
            cur.next = new ListNode(1);
        }

        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
