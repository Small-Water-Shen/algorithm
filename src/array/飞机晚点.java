package array;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ��β��Ҫȥ�ܶ�ܶ�ط��棬������һ������ n �Ż�Ʊ����ʼ��β���ڵ�һ�����У����������
 * i(1��i��n)���� i �Ż�Ʊ���Դӵ� i �����зɵ��� i+1 �����С������ʱ��ͽ���ʱ��ֱ�Ϊai��bi����
 * Ϊ����һ��ɻ���վ���ܸ�����һ��ɻ�����β�������Ʊ��ʱ��֤���� ����� i �� i+1����
 * ai��bi��ai+1��bi+1 �������ڲ��ɿ�����ĳЩ�ɻ�����㡣�������ĳ�Ż�Ʊi(1��i��n),��Ʊ��ʵ�ʽ���ʱ��ci����
 * ci>ai+1,��β�������Ϊ���Ǻ���֮���һ���ܵ���ϡ� ���зɻ�����ɽ����ʱ����Ϊ������
 * ��֪���зɻ������ʱ��֮��Ϊ t���������ж����麽��֮��ĵܵ���ϡ������Ķ��壺 ����ĳ���ɻ����ʱ��Ϊ x�����������ʱ�䲻�䣬����ʱ���Ӻ� x
 * �����������ȸ������������� n �� t���������� n �Ż�Ʊ�����зɻ����ʱ���Ϊ t�� 
 * Ȼ������� n �У�ÿ�и�������ʱ������һ���ɻ�����ɺͽ���ʱ�䡣 1��n��105  1��a,b,t��109
 * �������: ���һ��һ����������ʾ��
 * ����
 * 3 2
 * 1 2
 * 2 3
 * 3 4 
 * ��� 2 
 * ˵�� ��һ������͵ڶ�����������һСʱ����ʵ����ɺͽ���ʱ��ֱ�Ϊ[1,3]��[2,4],[3,4]. 
 * ��������ܵ���ϡ�����[1,2]�����࣬�͵�[2,3]������
 */
public class �ɻ���� {
	
	static long n, t;
	static long[] diff = new long[100005];
	static pair[] ti = new pair[100005];

	static class pair {
		long s, e;
		public pair(long s, long e) {
			this.s = s;
			this.e = e;
		}
	}

	// �������ʱ���,����֮���жϾ���
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextLong();
		t = input.nextLong();
		int p = 1;
		for (int i = 1; i <= n; i++) {
			ti[i] = new pair(input.nextLong(), input.nextLong());
			if (i == 1) continue;
			diff[p++] = ti[i].s - ti[i - 1].e;
		}
		Arrays.sort(diff, 1, p);
		int cnt = 0;
		for (int i = 1; i < p; i++) {
			if (t > diff[i]) {
				t -= (diff[i] + 1);
			} else break;
			++cnt;
		}
		System.out.println(cnt);
		input.close();
	}

}
