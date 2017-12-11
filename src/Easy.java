import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liming
 * @date Created in 2017/11/24 16:00
 */
public class Easy {
	//1,21,191,226,345,367,443,448,476,557,657

	/**
	 * 1
	 */
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
/////////////////////////////////////////////////////////////////////////

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
/////////////////////////////////////////////////////////////////////////

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
/////////////////////////////////////////////////////////////////////////

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
/////////////////////////////////////////////////////////////////////////

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
/////////////////////////////////////////////////////////////////////////

	/**
	 * 367
	 */
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
/////////////////////////////////////////////////////////////////////////

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
/////////////////////////////////////////////////////////////////////////

	/**
	 * 448
	 */
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
/////////////////////////////////////////////////////////////////////////

	/**
	 * 476
	 */
	public int findComplement(int num) {
		String n = Integer.toBinaryString(num);
		n = n.replaceAll("1", "2");
		n = n.replaceAll("0", "1");
		n = n.replaceAll("2", "0");
		return Integer.valueOf(n, 2);
	}
/////////////////////////////////////////////////////////////////////////

	/**
	 * 557
	 */
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
/////////////////////////////////////////////////////////////////////////

	/**
	 * 657
	 */
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


	public static void main(String[] args) {
		new Easy().reverseVowels("aA");
//		compress(new char[]{'a', 'b', 'b', 'b', 'c', 'c', 'c'});
	}

}
