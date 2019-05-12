package algorithm_practices;

import java.util.Scanner;

/* ��ѧ����
 * �������� A��A1= ����Ķ���~~
 * Ai=(Ai-1 + 7*i)%M, i>=2
 * �������� B��Bi=��d|i Ad
 * ����Ҫ�����е�Bi����������
 * ��������ֻҪ���������������һ������~
 * ��������: ��һ����������N,A1,M
 * �������: ��һ��һ����������ʾ�𰸡�
 */
public class MangSum {

	static long n, m;
	static long[] A = new long[2000001];
	static long[] B = new long[2000001];
	
	public static void solve() {
		for (int i = 2; i <= n; i++) A[i] = (A[i - 1] + (7 * i)) % m;
		for (int d = 1; d <= n; d++) {
			for (int j = d; j <= n; j += d) B[j] += A[d];
		}
		long res = 0;
		for (int i = 1; i <= n; i++) res ^= B[i];
		System.out.println(res);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextLong();
		A[1] = input.nextLong();
		m = input.nextLong();
		solve();
		input.close();
	}

}
