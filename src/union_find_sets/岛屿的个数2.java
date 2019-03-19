package union_find_sets;

import java.util.ArrayList;
import java.util.List;

/*
 * ���� n, m, �ֱ����һ����ά���������������, ������һ����СΪ k �Ķ�Ԫ����A. 
 * ��ʼ��ά����ȫ0. ��Ԫ����A�ڵ�k��Ԫ�ش���k�β���, ���i��Ԫ��Ϊ (A[i].x, A[i].y), 
 * ��ʾ�Ѷ�ά�������±�ΪA[i].x��A[i].y�е�Ԫ���ɺ����Ϊ����. 
 * ����ÿ�β���֮��, ��ά�����е��������. ����Ҫ����һ����СΪk������.
 * ����: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
	���: [1,1,2,2]
	����: 
	0.  00000
	    00000
	    00000
	    00000
	1.  00000
	    01000
	    00000
	    00000
	2.  01000
	    01000
	    00000
	    00000
	3.  01000
	    01000
	    00000
	    00010
	4.  01000
	    01000
	    00000
	    00011
 */
public class ����ĸ���2 {

	public static class Point {
		int x;
		int y;

		Point() {
			
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static List<Integer> numIslands2(int n, int m, Point[] operators) {
		if (operators == null || operators.length == 0 || n == 0 || m == 0) {
			return null;
		}
		// write your code here
		List<Integer> res = new ArrayList<>();
		// map
		boolean[] vis = new boolean[n * m];
		// parents of array
		int[] pre = new int[n * m];
		// direction
		int[][] dir = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
		// initialize
		for (int i = 0; i < pre.length; i++) {
			pre[i] = i; 
			vis[i] = false; 
		}
		int count = 0;
		for (int i = 0; i < operators.length; i++) {
			// �Զ�ά������б�ţ���0��i*m+j
			int x = operators[i].x;
			int y = operators[i].y;
			int pos = x * m + y;
			// �Ѳ�����������һ�β�������Ŀ����res��skip
			if (vis[pos]) {
				res.add(count);
				continue;
			}
			vis[pos] = true;
			count++;
			// ���ܲ鿴
			for (int j = 0; j < 4; j++) {
				int n_x = x + dir[j][0];
				int n_y = y + dir[j][1];
				int n_pos = n_x * m + n_y;
				// overstep or not island
				if (n_x < 0 || n_y < 0 || n_x >= n || n_y >= m || !vis[n_pos]) {
					continue;
				}
				// �ҵ�n_pos��root
				int root = findPre(pre, n_pos);
				// union
				if (root != pos) {
					pre[pos] = root;  // ����pos����
					pos = root;  // ·��ѹ���������ظ�����
					count--;  // ����ͨ�ģ���������
				}
			}
			res.add(count);
		}
		return res;
	}
	
	// inefficient (don't use)
	public static int statistic(int[] pre, boolean[] vis, int n, int m) {
		int count = 0;
		for (int i = 0; i < pre.length; i++) {
			if (pre[i] == i && vis[i]) {
				count++;
			}
		}
		return count;
	}

	// inefficient, �����ܽ��в鲢�� (don't use)
	public static void unionFind(int[] pre, boolean[] vis, int n, int m, int x, int y, int root) {
		if (x - 1 >= 0 && vis[(x - 1) * m + y]) union(pre, root, (x - 1) * m + y);
		if (y - 1 >= 0 && vis[x * m + (y - 1)]) union(pre, root, x * m + (y - 1));
		if (x + 1 < n && vis[(x + 1) * m + y])	union(pre, root, (x + 1) * m + y);
		if (y + 1 < m && vis[x * m + (y + 1)])	union(pre, root, x * m + (y + 1));
	}

	// find root
	public static int findPre(int[] pre, int x) {
		int r = x;
		while (pre[r] != r) {
			r = pre[r];
		}
		// ·��ѹ���㷨
		int i = x, j;
		while(pre[i] != r){
			j = pre[i];
			pre[i] = r;
			i = j;
		}
		return r;
	}

	// union  (don't use)
	public static void union(int[] pre, int x, int y) {
		int a = findPre(pre, x);
		int b = findPre(pre, y);
		if (a != b) {
			pre[a] = b;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] operators = new Point[4];
		operators[0] = new Point(0, 0);
		operators[1] = new Point(0, 1);
		operators[2] = new Point(3, 3);
		operators[3] = new Point(3, 4);
		System.out.println(numIslands2(4, 5, operators).toString());
	}

}
