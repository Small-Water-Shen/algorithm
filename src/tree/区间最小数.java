package tree;

import java.util.ArrayList;
import java.util.List;

/*
 * ����һ���������飨�±��� 0 �� n-1������ n ��ʾ����Ĺ�ģ�����Լ�һ����ѯ�б�
 * ÿһ����ѯ�б����������� [start, end]�� ����ÿ����ѯ�������������
 * ���±� start �� end ֮���������Сֵ���������ڽ���б��С�
 * ���룺���� ��[1,2,7,8,5] ��ѯ ��[(1,2),(0,4),(2,4)]�������[2,1,5]
 * ÿ�β�ѯ��O(logN)��ʱ�������
 */
public class ������С�� {
	
	static final int MAX = Integer.MAX_VALUE;
	
	public static class Interval {
		int start, end, min;
		Interval left, right;
		public Interval(int start, int end, int min) {
			this.start = start;
			this.end = end;
			this.min = min;
			this.left = null;
			this.right = null;
		}
	}
	
	public static Interval build(int[] A, int start, int end) {
		if (start == end) {
			return new Interval(start, end, A[start]);
		}
		int mid = (start + end) >> 1;
		Interval node = new Interval(start, end, 0);
		node.left = build(A, start, mid);
		node.right = build(A, mid + 1, end);
		node.min = Math.min(node.left.min, node.right.min);
		return node;
	}
	
	// �����ѯ��Сֵ
	public static int query(Interval root, int start, int end) {
		int l = root.start, r = root.end;
		if (start <= l && r <= end) {
			return root.min;
		}
		int mid = (l + r) >> 1, ll = MAX, rr = MAX;
		if (start <= mid) ll = query(root.left, start, end);
		if (end > mid) rr = query(root.right, start, end);
		return Math.min(ll, rr);
	}

    public static List<Integer> intervalMinNumber(int[] A, List<Interval> queries) {
        // write your code here
    	List<Integer> ant = new ArrayList<>();
    	if (A == null || queries == null || queries.isEmpty()) {
    		return ant; 
    	}
    	Interval root = build(A, 0, A.length - 1);
    	for (Interval inter : queries) {
			ant.add(query(root, inter.start, inter.end));
		}
    	return ant;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 7, 8, 5 };
		List<Interval> queries = new ArrayList<>();
		// ��Ҫ��ѯ������
		queries.add(new Interval(1, 2, 0));
		queries.add(new Interval(0, 4, 0));
		queries.add(new Interval(2, 4, 0));
		System.out.println(intervalMinNumber(arr, queries));
	}

}
