package greedy;

import java.util.Scanner;

/* 
 * ��β�ƴӺ��ݻ������ڻ�������·���ϴ��֮�����������·���һ���鷳���¡�
 * �������ĳ���ֻ��L������β����N���·���ÿ���·������¼���֮����Ժ�����������������
 * �������Ƚ�ռ�������ĵط��������ܹ�����󣬸ɵ�Ҳ�죬��������֮��
 * ��β��ÿ�춼Ҫר�����ȣ�ûʱ�����Щ�·��������ڹҺ�ÿ���·�֮��Ͳ����ٵ�����
 * ��ֻϣ�������Ŀ��������·�ȫ�������ɡ�
 * ����Ｆβ�����㣬�����������ž��߹��·������羭���೤ʱ�䣬�����·����ܱ����ɡ�
 * �������Զ�޷�һ�������������·������-1��
 * ��������: ��һ�и���N,L (1��N��2e5, 1��L��1e9)
 * ������N�������·���ÿ��������֣��ֱ����ʪ��a�����ռ���¼ܵĳ���b�����ÿ���Ӽ��ٵ�ʪ��c�����ų���d������ÿ���Ӽ��ٵ�ʪ��e��b>d,c>e,1��a,b,c,d,e��1e9��
 * �������: ���һ��һ����������𰸡�
 * ����
 * 2 10
 * 100 10 100 1 1
 * 10 3 5 2 3
 * ��� 100
 */
public class ���·� {
	
	// ����+̰���ж�
	static final int MAX = 200050;
	
	static long N, L;
	static clothe[] clothes = new clothe[MAX];

	public static class clothe {
		long a, b, c, d, e;
		public clothe(long a, long b, long c, long d, long e) {
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
		}
	}
	
	// ����, ����1��1e9��ʱ��
	public static long binary() {
		long ant = -1;
		long l = 1, r = 1000000000;
		while (l <= r) {
			long mid = (l + r) >> 1;
			if (greed(mid)) {
				ant = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return ant;
	}
	
	// ̰��check, ��ǰʱ���Ƿ������������·�
	public static boolean greed(long time) {
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			// ��Ŷ���������
			if (clothes[i].a > time * clothes[i].c) return false;			
			else {
				// ���
				if (clothes[i].a > time * clothes[i].e) {
					sum += clothes[i].b;
				} 
				// ����
				else {
					sum += clothes[i].d;
				}
			}
			if (sum > L) return false; // ��������
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextLong();
		L = input.nextLong();
		for (int i = 1; i <= N; i++) {
			clothes[i] = new clothe(input.nextLong(), 
					input.nextLong(), input.nextLong(), 
					input.nextLong(), input.nextLong()); 
		}
		System.out.println(binary());
		input.close();
	}

}
