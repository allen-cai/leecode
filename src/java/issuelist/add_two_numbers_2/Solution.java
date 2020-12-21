package issuelist.add_two_numbers_2;

/**
 * @Description
 * @Author allen
 * @Date 2020/12/21 9:35
 * @ClassName Solution
 **/
public class Solution {

    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l = l1;
        for (int i = 0; i < 7; i++) {
            l.val = 9;
            l.next = new ListNode();
            l = l.next;
        }

        ListNode l2 = new ListNode();
        l = l2;
        for (int i = 0; i < 4; i++) {
            l.val = 9;
            l.next = new ListNode();
            l = l.next;
        }

        Solution solution = new Solution();
        ListNode node = solution.addTwoNumbers(l1, l2);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int pre = 0;
        ListNode result = new ListNode();
        ListNode res = result;
        while (l1 != null || l2 != null) {
            int t = 0;
            if (l1 != null) {
                t += l1.val;
            }

            if (l2 != null) {
                t += l2.val;
            }
            //前结点值（进位）
            t += pre;

            //进位
            pre = t / 10;

            res.val = t % 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }

            if (l1 != null || l2 != null) {
                res.next = new ListNode();
                res = res.next;
            } else {
                if (pre > 0) {
                    res.next =  new ListNode(pre);
                }
                return result;
            }
        }

        return result;
    }
}
