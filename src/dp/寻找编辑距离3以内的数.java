package dp;

/*
 * ��һ�ڸ���, ����һ����,�ҳ������༭������3���ڵ���
 * ������6(0110), �ҳ�0010����...
 * 
 * ע: ���㷨����������������Ҫ��;, 
 * ������: ����Ӧ��. ����û�й����ƥ����Ϣ, ���Ի�²���������������, ��ʾ���ǲ���Ҫ����: ����Ӣ��.
 * */

public class Ѱ�ұ༭����3���ڵ��� {

	static int[] data;
	static final int N = 3;

	public static void init(int n) {
		data = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			data[i] = i;
		}
	}

	// Ѱ�Ҷ�������1�ĸ���
	public static boolean withIn3(int i) {
		int count = 0;
		while (i != 0) {
			if ((i & 1) == 1) {
				count++;
			}
			if (count >= N) {
				return false;
			}
			i >>= 1;
		}
		return true;
	}

	public static void search(int number) {
		for (int i = 0; i < data.length; i++) {
			// ���õ�����ͬ�ĸ���(1��Ϊ����ͬ,0Ϊ��ͬ)
			if (withIn3(number ^ data[i])) {
				System.out.println(data[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init(100_000_000);
		int number = 6;
		search(number);
	}

}
