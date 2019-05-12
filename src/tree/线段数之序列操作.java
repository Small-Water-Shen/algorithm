package tree;

import java.util.Scanner;

/* ���߶�����
 * ����һ������Ϊn�����У���ʼΪ1,2,3...n���������m�β�����
 * ���������֣�
 * 1 l r  ��ʾ������[l,r]�� [1,2...r-l+1] ����
 * 2 l r ��ѯ[l,r]�������
 * ��������: ��һ�а���2�����֣�n,m��1 <= n,m <= 1e5�� ����������m�У���ʽ��������ʾ
 * �������: ����ÿ������2�����һ��һ��������ʾ��
 * ����
 * 10 5
 * 2 1 10
 * 1 3 6
 * 2 1 10
 * 1 1 10
 * 2 1 10
 * ��� 55 47 55
 */
public class �߶���֮���в��� {
    
	static final int MAX = 100005;
    static int n, m;
    static Tree[] arr = new Tree[MAX << 2]; // fourfold space(��Ҷ�ӽڵ�Ҳռ�ռ�)
    
    public static class Tree {
    	long l, r, lazyl, lazyr, sum;
		public Tree(long l, long r, long lazyl, long lazyr, long sum) {
			this.l = l; 
			this.r = r;
			this.lazyl = lazyl; 
			this.lazyr = lazyr;
			this.sum = sum;
		}
    }
    
    public static void init() {
    	for (int i = 1; i <= (n << 2); i++) arr[i] = new Tree(0, 0, 0, 0, 0); 
    }
    
    // �ϲ�����ǰ�Ľڵ�sum�������ҽڵ��sum
    public static void merge(int k) {
    	arr[k].sum = arr[k << 1].sum + arr[(k << 1) | 1].sum;
    }
    
    // ����
    public static void build(long l, long r, int k) {
    	arr[k].l = l;
    	arr[k].r = r;
    	arr[k].lazyl = 0;
    	arr[k].lazyr = 0;
    	if (l == r) {
    		arr[k].sum = l;
    		return;
    	}
    	long mid = (l + r) >> 1;
    	build(l, mid, k << 1); // ����������(2*k)
    	build(mid + 1, r, (k << 1) | 1); // ����������(2*k+1)
    	merge(k); // �ϲ�
    }
    
    // ����[ql, qr]��ѯ
    public static long query(int k, long ql, long qr) {
    	// ��ǰ������Ҫ��ѯ������Ӽ�����ȫ������
    	if (ql <= arr[k].l && arr[k].r <= qr) return arr[k].sum;
    	// �´����
    	if (arr[k].lazyr != 0 && arr[k].lazyl != 0) pushDown(k);
    	long sum = 0;
    	long mid = (arr[k].l + arr[k].r) >> 1;
    	// ��ѯ��������һ���ֻ��ڵ�ǰ��������
    	if (ql <= mid) sum += query(k << 1, ql, qr);
    	// ��ѯ��������һ���ֻ��ڵ�ǰ������ұ�
    	if (qr > mid) sum += query((k << 1) | 1, ql, qr);
    	return sum;
    }
    
    // ���������
    public static long calc(int k) {
    	long len = (arr[k].lazyr - arr[k].lazyl + 1); // lazy�ĸ���
    	return len * (arr[k].lazyr + arr[k].lazyl) / 2; // �Ȳ��������
    }
    
    // ���������
    public static void pushDown(int k) {
    	arr[k << 1].lazyl = arr[k].lazyl;
    	arr[k << 1].lazyr = (arr[k].lazyl + arr[k].lazyr) >> 1;
    	arr[k << 1].sum = calc(k << 1);
    	arr[(k << 1) | 1].lazyl = ((arr[k].lazyl + arr[k].lazyr ) >> 1) + 1;
    	arr[(k << 1) | 1].lazyr = arr[k].lazyr;
    	arr[(k << 1) | 1].sum = calc((k << 1) | 1);
    	// ����
    	arr[k].lazyl = 0;
    	arr[k].lazyr = 0;
    }
    
    // �����޸�
    public static void update(int k, long ul, long ur) {
    	// �ݹ鵽��Ҫ�޸ĵĽڵ㣬��ʼ��¼ lazy label
    	if (ul <= arr[k].l && arr[k].r <= ur) {
    		// ����
    		arr[k].lazyl = arr[k].l - ul + 1;
    		arr[k].lazyr = arr[k].r - ul + 1;
    		arr[k].sum = calc(k); // ��������Ǻ�
    		return;
    	}
    	// �´����
    	if (arr[k].lazyr != 0 && arr[k].lazyl != 0) pushDown(k);
    	long mid = (arr[k].l + arr[k].r) >> 1;
    	if (ul <= mid) update(k << 1, ul, ur);
    	if (ur > mid) update((k << 1) | 1, ul, ur);
    	merge(k); // �ϲ�
    }
    
    // ǰ׺�� (TLE), ���߶���
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        m = input.nextInt();
        init();
        build(1, n, 1);
        while (m-- > 0) {
            int op = input.nextInt();
            int l = input.nextInt();
            int r = input.nextInt();
            if (op == 1) update(1, l, r);       	
            else if (op == 2) System.out.println(query(1, l, r));
        }
        input.close();
    }
}