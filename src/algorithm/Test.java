package algorithm;

public class Test {
	/*
	 * ���̨����Ŀ����2������ô���ȵ�һ����������ѡ�񣺵�һ����1�������ߵ�һ����������
	 * �������˵�һ�κ�ߵ��߷��������������Σ�climbStairs(n-1)��climbStairs(n-2)��
	 * ����һֱ�ݹ���ȥ��ֱ�����ֵ��˻������Σ���n=1��n=2�����Σ����ݹ鵽����ط����������Σ� Ȼ��ʼ���� ���������˵�ĺ͵ݹ�������صġ����ݡ��ˡ�
	 * ���ݣ�����˼����Ǵӽ�����Ż�ȥ���ҵ��������̣������������·������˵��ʵ�ֵĹ���
	 */
	public static long ClimStair(long n) {
		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		} else {
			return ClimStair(n - 1) + ClimStair(n - 2);
		}
	}

	public static void main(String args[]) {
		long a = ClimStair(6);
		System.out.println(a);
	}
}
