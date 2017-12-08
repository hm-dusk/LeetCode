/**
 * @author liming
 * @date Created in 2017/11/24 16:00
 */
public class Easy {

	/**
	 * 268
	 */
	public int missingNumber(int[] nums) {
		return 0;
	}

	/**
	 * 21
	 */
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/**
	 * 21
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode preHead = new ListNode(-1);

		ListNode pre = preHead;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				pre.next = l1;
				l1 = l1.next;
			} else {
				pre.next = l2;
				l2 = l2.next;
			}
			pre = pre.next;
		}

		pre.next = l1 == null ? l2 : l1;
		return preHead.next;
	}

}
