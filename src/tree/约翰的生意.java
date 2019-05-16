package tree;

import java.util.Arrays;

/* TLE
 * ��һ�������ϣ���n�����У���Ŵ�0 ~ n �C 1 , Լ����������n�������������⣬����Armani��һ���������Ȥ��
 * ÿ�����ж����������ﶼ��һ���۸�prices[i]�����ڳ���x,Լ���ɴӳ��б��Ϊ[x - k, x + k]������
 * Ȼ����������x,��Լ����ÿ�����������׬������Ǯ�� prices.length ��ΧΪ[2, 100000], k <= 100000��
 * ����: prices = [1, 3, 2, 1, 5] �� k = 2
 * ���: [0, 2, 1, 0, 4]
 * ����: 
 * i = 0��Լ����ȥ�ĳ�����0~2��Ϊ1��2�ų��еļ۸��0�ų��еļ۸�ߣ�����׬����Ǯ���� ans[0] = 0��
 * i = 1����ȥ�ĳ�����0~3�����Դ�0�Ż���3�ų��й������׬ȡ�Ĳ����󣬼�ans[1] = 2��
 * i = 2����ȥ�ĳ�����0~4����Ȼ��3�ų��й������׬ȡ�Ĳ����󣬼�ans[2] = 1��
 * i = 3����ȥ�ĳ�����1~4��û���������еļ۸��3�ų��м۸�ͣ�����׬����Ǯ��ans[3] = 0��
 * i = 4����ȥ�ĳ�����2~4����3�ų��й������׬ȡ�Ĳ����󣬼�ans[4] = 4��
 */
public class Լ�������� {
	
	static final int MAX = Integer.MAX_VALUE;

    public static class Tree {
        int start, end, min;
        Tree left, right;
        public Tree(int start, int end) {
            this.start = start;
            this.end = end;
            this.min = MAX;
            this.left = null;
            this.right = null;
        }
    }

    public static void merge(Tree root) {
        root.min = Math.min(root.left.min, root.right.min);
    }

    public static Tree build(int[] A, int start, int end) {
    	if (start > end) return null;
        Tree node = new Tree(start, end);
        if (start == end) {
        	node.min = A[start];
            return node;
        }
        int mid = (node.start + node.end) >> 1;
        node.left = build(A, start, mid);
        node.right = build(A, mid + 1, end);
        merge(node);
        return node;
    }

    public static int query(Tree root, int start, int end) {
        if (root == null || start > end || start > root.end || end < root.start) {
        	return MAX;
        }
        if (start <= root.start && root.end <= end) {
            return root.min;
        }
        int mid = (root.start + root.end) >> 1;
        int min = MAX;
        if (start <= mid) min = Math.min(min, query(root.left, start, end));
        if (end > mid) min = Math.min(min, query(root.right, start, end));
        return min;
    }

    public static int[] business(int[] A, int k) {
        // write your code here
        int len = A.length, p = 0;
        int[] ant = new int[len];
        if (len == 0) {
            return ant;
        }
        Tree root = build(A, 0, len - 1);
        for (int i = 0; i < len; i++) {
        	int start = (i - k) >= 0 ? (i - k) : 0;
        	int end = (i + k) < len ? (i + k) : len - 1;
            int min = query(root, start, end);
            System.out.println(start + " " + end + " " + min);
            ant[p++] = (min >= A[i]) ? 0 : A[i] - min; 
        }
        return ant;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 1, 3, 2, 1, 5 };
        System.out.println(Arrays.toString(business(arr, 2)));
    }

}
