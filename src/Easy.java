import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

	/**
	 * 226
	 */
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	/**
	 * 226
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}

	/**
	 * 191
	 */
	public int hammingWeight(int n) {
		int count = 0;
		char[] a = Integer.toBinaryString(n).toCharArray();
		for (char c : a) {
			if (c == '1') {
				count++;
			}
		}
		return count;
	}

	/**
	 * 443
	 */
	public int compress(char[] chars) {
		int anchor = 0, write = 0;
		for (int read = 0; read < chars.length; read++) {
			if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
				chars[write++] = chars[anchor];
				if (read > anchor) {
					for (char c : ("" + (read - anchor + 1)).toCharArray()) {
						chars[write++] = c;
					}
				}
				anchor = read + 1;
			}
		}
		return write;
	}

	/**
	 * 345
	 */
	public String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		List<Integer> index = new ArrayList<>();
		List<Character> yuanList = new ArrayList<>();
		for (int i = 0; i < chars.length; i++) {
			if (isYuan(chars[i])) {
				index.add(i);
				yuanList.add(chars[i]);
			}
		}
		Collections.reverse(yuanList);
		for (int i = 0; i < index.size(); i++) {
			chars[index.get(i)] = yuanList.get(i);
		}
		StringBuilder sb = new StringBuilder();
		for (char c : chars) {
			sb.append(c);
		}
		return sb.toString();
	}
	/**
	 * 345
	 */
	private boolean isYuan(char a) {
		return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'
				|| a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
	}

	public static void main(String[] args) {
		new Easy().reverseVowels("aA");
//		compress(new char[]{'a', 'b', 'b', 'b', 'c', 'c', 'c'});
	}

}
