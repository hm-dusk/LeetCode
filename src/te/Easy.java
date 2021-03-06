package te;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author liming
 * @date Created in 2017/11/24 16:00
 */
public class Easy {
	//1,21,191,206,217,226,242,345,367,415,443,448,476,557,657

	/******************************** 1 ************************************/
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[]{i, j};
				}
			}
		}
		throw new IllegalArgumentException();
	}

	/******************************** 21 ************************************/
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

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

	/******************************** 168 ************************************/
	public String convertToTitle(int n) {
//		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		char[] ss = s.toCharArray();
//		if (n <= 26) {
//			return String.valueOf(ss[n - 1]);
//		} else {
//			String result = "";
//			int a = n / 26;
//			for (int i = 0; i < a; i++) {
//				result += "A";
//			}
//			return result + String.valueOf(ss[n % 26 - 1]);
//		}
		return "";
	}

	/******************************** 191 ************************************/
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

	/******************************** 206 ************************************/
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	/******************************** 217 ************************************/
	public boolean containsDuplicate(int[] nums) {
		long l = Arrays.stream(nums).distinct().count();
		return nums.length > l;
	}

	/******************************** 226 ************************************/
	private class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

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

	/******************************** 237 ************************************/
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	/******************************** 242 ************************************/
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] table = new int[26];
		for (int i = 0; i < s.length(); i++) {
			table[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			table[t.charAt(i) - 'a']--;
			if (table[t.charAt(i) - 'a'] < 0) {
				return false;
			}
		}
		return true;
	}

	/******************************** 345 ************************************/
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

	private boolean isYuan(char a) {
		return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'
				|| a == 'A' || a == 'E' || a == 'I' || a == 'O' || a == 'U';
	}

	/******************************** 367 ************************************/
	public boolean isPerfectSquare(int num) {
		if (num == 1) {
			return true;
		}
		for (int i = 1; i <= num / 2; i++) {
			if (i * i == num) {
				return true;
			}
		}
		return false;
	}

	/******************************** 415 ************************************/
	public String addStrings(String num1, String num2) {
		if (num1.length() < num2.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}

		char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
		int flag = 0;
		for (int i = 0; i < n1.length; i++) {
			int a = n1[n1.length - 1 - i] - '0' + flag;
			if (i < n2.length) {
				a += (n2[n2.length - 1 - i] - '0');
			}
			if (a >= 10) {
				n1[n1.length - 1 - i] = (char) ('0' + a - 10);
				flag = 1;
			} else {
				n1[n1.length - 1 - i] = (char) ('0' + a);
				flag = 0;
			}
		}
		if (1 == flag) {
			return "1" + String.valueOf(n1);
		}
		return String.valueOf(n1);
	}

	/******************************** 443 ************************************/
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

	/******************************** 448 ************************************/
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		return ret;
	}

	/******************************** 476 ************************************/
	public int findComplement(int num) {
		String n = Integer.toBinaryString(num);
		n = n.replaceAll("1", "2");
		n = n.replaceAll("0", "1");
		n = n.replaceAll("2", "0");
		return Integer.valueOf(n, 2);
	}

	/******************************** 557 ************************************/
	public String reverseWords(String s) {
		String[] arr = s.split(" ");
		String[] arr2 = new String[arr.length];
		int index = 0;
		for (String s1 : arr) {
			char[] c = s1.toCharArray();
			char[] d = new char[c.length];
			int j = 0;
			for (int i = c.length - 1; i >= 0; i--) {
				d[j] = c[i];
				j++;
			}
			arr2[index] = String.valueOf(d);
			index++;
		}
		String result = "";
		for (String s1 : arr2) {
			result = result + s1;
			result += " ";
		}
		return result.substring(0, result.length() - 1);
	}

	/******************************** 657 ************************************/
	public boolean judgeCircle(String moves) {
		char[] move = moves.toCharArray();
		int x = 0;
		int y = 0;
		for (char one : move) {
			switch (one) {
				case 'U':
					y++;
					break;
				case 'D':
					y--;
					break;
				case 'L':
					x++;
					break;
				case 'R':
					x--;
					break;
				default:
					break;
			}
		}
		return x == 0 && y == 0;
	}

	/********************************   ************************************/


	public static void main(String[] args) {
		new Easy().reverseVowels("aA");
//		compress(new char[]{'a', 'b', 'b', 'b', 'c', 'c', 'c'});
	}

}
