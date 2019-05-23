package algorithm;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 - ����N����Ԫ��(a1,b1),(a2,b2),��,(aN,bN)���������ѡ��ǡ��K����ʹ��ai����Сֵ��bi����Сֵ֮�����
 * �����ai����Сֵ��bi����Сֵ֮��
 * Input:
 * 3 2
 * 1 1
 * 2 3 
 * 3 1
 * Output:
 * 3
 */
public class ��С��Ԫ�� {
	
	static class Pair implements Comparable<Pair> {
		int a;
		int b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			// ����a���򣬵�a��ȾͱȽ�b
			if (this.a == o.a) {
				return o.b - this.b;
			}
			return o.a - this.a;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int k = input.nextInt();
		Pair[] pairs = new Pair[N];
		for (int i = 0; i < N; i++) {
			pairs[i] = new Pair(input.nextInt(), input.nextInt()); 
		}
		Arrays.sort(pairs);
		int res = 0;
		// ������peek()����poll()��ȡ�������е�Ԫ��ʱ��������ȡ�����Ƚ�����е�Ԫ�أ�����ȡ����������С��Ԫ��
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < N; ++i) {
			queue.add(pairs[i].b); // �����b����Ϊa�Ѿ��ǽ����ˣ����ܱ�b��
			while (queue.size() > k) {
				queue.poll();
			}
			if (queue.size() == k) {
				res = Math.max(res, pairs[i].a + queue.peek()); // peek()��b����С��Ԫ��
			}
		}
		System.out.println(res);
		input.close();
	}

}
