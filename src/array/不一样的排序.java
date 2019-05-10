package array;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * ��һ����ķ³������ĸ粼�ֲ���ѧ��ѧ����Ϊ��֮ǰ�̹����ӣ������뿼�����ǡ�
 * ��ķ³�������� n ��������Ҫ�����Ӹ����Ķ��ٽ����������Ӹ���������ں��棬
 * ���Ӹ����ٵ�����ǰ�棬������Ӹ�����ͬ��ô�ͱȽ�������Ĵ�С������ķ��ں��棬��С�ķ���ǰ�档��������˵������֮��� KK ��λ�õ������Ƕ��١�
 * ����� 1 ������Ϊ����K��1<=K<=10^6, �� 2 ��Ϊ���� n����ʾ���ֵ�������n<10^7 
 * �������� n ��������ÿ�����Ĵ�С������ 10^6
 * �������֮��ĵ� K λ�õ���ֵ��
 * �������� 4 6 1 2 3 4 5 6
 * ������� 5
 */
public class ��һ�������� {

	static long MAX = 1000005, res;
	static long[] factors = new long[(int) MAX];
	static pair[] pairs = new pair[(int) MAX];

	static class pair implements Comparable<pair>{
		long num, fac;

		public pair(long num, long fac) {
			this.num = num;
			this.fac = fac;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			int cmp = (int) (this.fac - o.fac);
			return (cmp != 0) ? cmp : (int) (this.num - o.num);
		}
	}

	// ���߻���������Χ��������������
	public static void init(long max) {
		for (int i = 1; i <= Math.sqrt(max); i++) {
			for (int j = i + 1; i * j <= max; j++) {
				factors[i * j] += 2;
			}
			factors[i * i] += 1;
		}
	}

	// ����<���֣� ������>, Ȼ���ÿ���ɸѡ����k��С����
	public static void solve(long k, long n, long[] arr) {
		res = -1;
		for (int i = 0; i < n; i++) pairs[i] = new pair(arr[i], factors[(int) arr[i]]);
//		for (int i = 0; i < n; i++) System.out.println(pairs[i].num + " " + pairs[i].fac);
		quickSort(0, n - 1, pairs, k);
		System.out.println(res);
	}
	
	// ά��һ�����ȶ���, ���pollֱ��k��
	public static void solve2(long k, long n, long[] arr) {
		ArrayList<pair> list = new ArrayList<>((int) n);
		for (int i = 0; i < n; i++) {
			list.add(new pair(arr[i], factors[(int) arr[i]]));
		}
		PriorityQueue<pair> queue = new PriorityQueue<>(list);
		while (--k > 0) {
			queue.poll();
		}
		System.out.print(queue.poll().num);
	}

	public static void quickSort(long left, long right, pair[] pairs, long k) {
		if (res != -1) return;
		int i = (int) left, j = (int) right;
		pair r = pairs[i];
		while (i < j) {
			while (i < j) {
				if (r.fac <= pairs[j].fac) --j;
				else if (r.fac == pairs[j].fac) {
					if (r.num <= pairs[j].num) --j;
					else break;
				} else break;
			}
			if (i < j) pairs[i++] = pairs[j];
			while (i < j) {
				if (r.fac >= pairs[i].fac) ++i;
				else if (r.fac == pairs[i].fac) {
					if (r.num >= pairs[i].num) ++i;
					else break;
				} else break;
			}
			if (i < j) pairs[j--] = pairs[i];
		}
		pairs[i] = r;
		if (i == k - 1) res = pairs[i].num;
		else if (i > k - 1) quickSort(left, i - 1, pairs, k);
		else quickSort(i + 1, right, pairs, k);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long k = input.nextLong();
		long n = input.nextLong();
		long[] arr = new long[(int) n];
		long max = Integer.MIN_VALUE;
		for (int i = 0, p = 0; i < n; i++) {
			arr[p] = input.nextLong();
			max = Math.max(max, arr[p++]);
		}
		init(max + 1);
		solve(k, n, arr);
		solve2(k, n, arr);
		input.close();
	}

}
