package doit;

/**
 * @author liming
 * @date Created in 2017/12/11 11:17
 */
public class Test {
//	public String addBinary(String a, String b) {
//
//	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

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

	public int findComplement(int num) {
		String s = Integer.toBinaryString(num);
		s = s.replaceAll("0", "2");
		s = s.replaceAll("1", "0");
		s = s.replaceAll("2", "1");
		return Integer.valueOf(s, 2);
	}

//	public String addBinary(String a, String b) {
////		int a1 = Integer.valueOf(a, 2);
////		int b1 = Integer.valueOf(b, 2);
////		return Integer.toBinaryString(a1 + b1);
//		char[] arrA = a.toCharArray();
//		char[] arrB = b.toCharArray();
//
//	}

	public int islandPerimeter(int[][] grid) {
		int allOne = 0;
		int comm = 0;
		int y = grid.length;
		int x = grid[0].length;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (grid[i][j] == 1) {
					allOne++;
				}
			}
		}
		return 0;
	}
}
