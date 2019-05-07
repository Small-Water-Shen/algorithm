package violence;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * ����һ�������һ��ֵt����һ��������ʹ����͵ľ���ֵ��t�Ĳ�ֵ��С��������ڶ��������ⶼ���С�
 * ÿ��������������������n��k��ʼ��������n=k=0��ֹ������1<=n<=100000���������n������ֵ<=10000��������
 * �������С�Ȼ����k��ѯ���д����С�ÿ����ѯ����һ��Ŀ��t��0<=t<=100000000��
 * ÿ����ѯ���3��ֵ: ������ĺͣ�������ʼλ��l,u
 */
public class ������ĺ͵ľ���ֵ��t����С��ֵ {

	static int n, k;
	static long t;
	static int[] data = new int[100010];

	static class pair {
		long sum;
		int index;
		public pair (long sum, int index) {
			this.sum = sum;
			this.index = index;
		}
	}
	
	/* ǰ׺��+��ȡ�� ͬ(��ӽ�����������)
	 * ������Ҫ�����������ĺͣ�����Ԥ����
	 * �ٲ��������ҳ�һ�����䣬���������ĺʹ��ڵ���t��ʱ��ֹͣ����Ϊ�����Ҳ�ֵ�͸����ˡ�
	 * Ȼ�����ƶ���˵��Լ�������ĺ͡�ע�⴦������͵ľ���ֵ
	 */
	public static void solve(Scanner input) {
		int s = 0, r = 1, l = 0, u = 0;
		long sum = 0, min = Integer.MAX_VALUE;
		pair[] pairs = new pair[n + 1];
		pairs[0] = new pair(0, 0);
		for (int i = 1; i <= n; i++) pairs[i] = new pair(pairs[i - 1].sum + data[i - 1], i);
		t = input.nextLong();
		// ע�⣬����ֻ����1~n
		Arrays.sort(pairs, new Comparator<pair>() {
			public int compare(pair o1, pair o2) { return (int) (o1.sum - o2.sum); }
		});
		for (pair p : pairs) System.out.println(p.sum + " " + p.index);
		while (r <= n) {
			// �����pairs[i]-pairs[i-1]һ������
			long v = Math.abs(pairs[r].sum - pairs[s].sum);
			if (Math.abs(t - v) < min) {
				min = Math.abs(t - v);
				sum = v;
				l = pairs[s].index;
				u = pairs[r].index;
			}
			if (v < t) ++r; // ���������ҳ�һ������
			else if (v > t) ++s; // ���������ĺʹ��ڵ���t��ʱ��ֹͣ����Ϊ�����Ҳ�ֵ�͸�����
			else break; // ��ȣ���ֵ0, minimum
			if (s == r) ++r;
		}
		// swap
		if (l > u) {
			l ^= u; u ^= l; l ^= u;
		}
		System.out.println(sum + " " + (l + 1) + " " + u);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			n = input.nextInt();
			k = input.nextInt();
			if (n == 0 && k == 0) break;
			for (int i = 0; i < n; i++) data[i] = input.nextInt(); 				
			while (k-- > 0) solve(input);
		}
		input.close();
	}

}
