package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * ����һ���������� ���±��� 0 �� n-1������ n ��ʾ����Ĺ�ģ����ֵ��Χ�� 0 �� 10000�����Լ�һ�� ��ѯ�б�
 * ����ÿһ����ѯ���������һ�����������㷵�ظ�������С�ڸ���������Ԫ�ص�������
 * ����: array =[1,2,7,8,5] queries =[1,8,5] ���:[0,4,2]
 */
public class ͳ�Ʊȸ�������С�����ĸ��� {

// -------------------sort + binary --------------------------------------------------------------
	public static List<Integer> sortBinary(int[] A, int[] queries) {
		List<Integer> ant = new ArrayList<Integer>();
		Arrays.sort(A);
		for (int i : queries) ant.add(binary(A, 0, A.length - 1, i));
		return ant;
	}
	
	// find index >= num
	public static int binary(int[] A, int l, int r, int num) {
		int ll = l, rr = r;
		while (ll <= rr) {
			int mid = (ll + rr) >> 1;
			if (num > A[mid]) {
				ll = mid + 1;
			} else {
				rr = mid - 1;
			} 
		}
		return ll;
	}
	
// ------------------- ����+ǰ׺��----------------------------------------------------------
    // Efficient
    public static List<Integer> prefix(int[] A, int[] queries, List<Integer> ant) {
        int[] counter = new int[MAX];
        int max = -1;
        for (int a : A) {
            counter[a]++;
            max = Math.max(max, a);
        }
        int[] pre = new int[max + 1];
        pre[0] = counter[0];
        for (int i = 1; i <= max; i++) pre[i] += pre[i - 1] + counter[i];
        for (int q : queries) ant.add(pre[q - 1]);
        return ant;
    }

// ------------------- �߶��� --------------------------------------------------------------
    static final int MAX = 10005;
    static Tree[] tree = new Tree[MAX << 2];

	// ����Ϊ0~���ֵ(Դ����)����ɼ���+����
    public static class Tree {
        int l, r, count;
        public Tree(int l, int r) {
            this.l = l;
            this.r = r;
            this.count = 0;
        }
    }

    public static void init(int n) {
        for (int i = 0; i < (n << 2); ++i) {
            tree[i] = new Tree(0, 0);
        }
    }

    public static int left(int k) {
        return k << 1;
    }

    public static int right(int k) {
        return (k << 1) | 1;
    }

    public static void build(int k, int start, int end) {
        tree[k].l = start;
        tree[k].r = end;
        if (start == end) return;
        int mid = (tree[k].l + tree[k].r) >> 1;
        build(left(k), start, mid);
        build(right(k), mid + 1, end);
    }

    // �������Դ���鲢����count
    public static void update(int k, int value) {
        if (tree[k].l == tree[k].r && tree[k].l == value) {
            tree[k].count++;
            return;
        }
        int mid = (tree[k].l + tree[k].r) >> 1;
        if (value <= mid) update(left(k), value);
        else update(right(k), value);
        tree[k].count = tree[left(k)].count + tree[right(k)].count;
    }

    public static int query(int k, int start, int end) {
        if (start > end) return 0;
        if (start == tree[k].l && tree[k].r == end) {
            return tree[k].count;
        }
        int mid = (tree[k].l + tree[k].r) >> 1;
        int res = 0;
        if (start <= mid) {
            // contain
            if (mid <= end) res += query(left(k), start, mid);
            // slipt
            else res += query(left(k), start, end);
        }
        if (end > mid) {
            // contain
            if (mid >= start) res += query(right(k), mid + 1, end);
            // slipt
            else res += query(right(k), start, end);
        }
        return res;
    }

    public static List<Integer> countOfSmallerNumber(int[] A, int[] queries) {
        // write your code here
        List<Integer> ant = new ArrayList<Integer>();
        if (A == null || A.length == 0) {
            if (queries.length != 0) {
                for (int i = 0; i < queries.length; i++) ant.add(0);
            }
            return ant;
        }
        // get maximum n
        int n = 0;
        for (int i : A) n = Math.max(i, n);
        init(n);
        build(1, 0, n);
        // �Ƚ�����ֵ���룬��ɼ�������
        for (int a : A) update(1, a);
        for (int query : queries) {
            // С��query�ĸ���: 0 ~ query-1�����ڵĸ���
            ant.add(query(1, 0, query - 1));
        }
        return ant;
    }

}
