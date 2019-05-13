package tree;

import java.util.Scanner;

public class �߶��� {

	static int n;
	static Tree[] tree;
	
	public static class Tree {
		int l, r;
		int lazy;
		int sum;
		public Tree(int l, int r, int lazy, int sum) {
			super();
			this.l = l;
			this.r = r;
			this.lazy = lazy;
			this.sum = sum;
		}
		@Override
		public String toString() {
			return "Tree [l: " + l + ", r: " + r + ", lazy: "
					+ lazy + ", sum: " + sum + "]";
		}
	}
	
	public static void init() {
		// fourfold space(��Ҷ�ӽڵ�Ҳռ�ռ�)
		tree = new Tree[(n << 2) + 10]; 
		for (int i = 1; i <= (n << 2); ++i) { 
			tree[i] = new Tree(0, 0, 0, 0);
		}
	}
	
	// �鿴���нڵ�
	public static void show() {
		for (int i = 1; i < (n << 1); i++) { 
			System.out.println(i + ": " + tree[i].toString());
		}
	}
	
	public static int left(int k) {
		return k << 1;
	}
	
	public static int right(int k) {
		return (k << 1) | 1;
	}
	
    // �ϲ�����ǰ�Ľڵ�sum�������ҽڵ��sum֮��
	public static void merge(int k) {
		tree[k].sum = tree[left(k)].sum + tree[right(k)].sum;
	}
	
	// lazy�´�
	public static void pushDown(int k) {
		// ��ǰ��lazyֵ�ۻ����ӽڵ���
		tree[left(k)].lazy += tree[k].lazy;
		tree[right(k)].lazy += tree[k].lazy;
		// �޸��ӽڵ��״ֵ̬,�������*��������lazy
		tree[left(k)].sum += (tree[left(k)].r - tree[left(k)].l + 1) * tree[k].lazy;
		tree[right(k)].sum += (tree[right(k)].r - tree[right(k)].l + 1) * tree[k].lazy;
		// ��ǰ�ڵ�lazy����
		tree[k].lazy = 0;
	}
	
	public static void build(int k, int ll, int rr) {
		tree[k].l = ll;
		tree[k].r = rr;
		tree[k].lazy = 0;
		if (ll == rr) {
			tree[k].sum = ll;
			return;
		}
		int mid = (ll + rr) >> 1;
		build(left(k), ll, mid); // ����������(2*k)
		build(right(k), mid + 1, rr); // ����������(2*k+1)
		merge(k); // �ϲ�
	}
	
	// �����ѯ(����)
	public static int query(int k) {
		if (tree[k].l == tree[k].r) return tree[k].sum;
		if (tree[k].lazy != 0) pushDown(k); // ��lazy
		int mid = (tree[k].l + tree[k].r) >> 1;
		if (k <= mid) return query(left(k)); // ����������(2*k)
		return query(right(k)); // ����������(2*k+1)
	}
	
	// �����޸�(����˼·)
	public static void update(int k, int value) {
		if (tree[k].l == tree[k].r) {
			tree[k].sum += value;
			return;
		}
		int mid = (tree[k].l + tree[k].r) >> 1;
		if (k <= mid) update(left(k), value);
		else update(right(k), value);
		merge(k); // update sum of node
	}
	
	// �����ѯ
	public static int queryInterval(int k, int ql, int qr) {
		int l = tree[k].l, r = tree[k].r;
		if (ql <= l && r <= qr) return tree[k].sum;
		if (tree[k].lazy != 0) pushDown(k); // ��lazy
		int sum = 0;
		int mid = (l + r) >> 1;
		if (ql <= mid) sum += queryInterval(left(k), ql, qr);
		if (qr > mid) sum += queryInterval(right(k), ql, qr);
		return sum;
	}
	
	// �����޸ģ�ÿ�������Ӽ�value
	public static void updateInterval(int k, int ul, int ur, int value) {
		int l = tree[k].l, r = tree[k].r;
		if (ul <= l && r <= ur) {
			tree[k].sum += (r - l + 1) * value; // �������*value
			tree[k].lazy += value; // update lazy
			return;
		}
		// ������Ŀ�귶Χ��ʱ���´�lazy��ֵ
		if (tree[k].lazy != 0) pushDown(k);
		int mid = (l + r) >> 1;
		if (k <= mid) updateInterval(left(k), ul, ur, value);
		if (k > mid) updateInterval(right(k), ul, ur, value);
		merge(k); // update sum of node
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		init();
		build(1, 1, n);
		show();
		update(2, -1);
		System.out.println(query(2));
		System.out.println(queryInterval(1, 1, 3));
		updateInterval(1, 1, 3, 2);
		System.out.println(queryInterval(1, 1, 3));
		show();
		input.close();
	}

}
