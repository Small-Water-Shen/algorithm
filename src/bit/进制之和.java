package bit;

import java.util.Scanner;

/*
 * ��һ�����Ȳ����� 18 �� 01 ��������Ҫ���������� 2, 3, 4, 5, 6, 7, 8, 9, 10 ���Ʊ�ʾ�µ���ֵ�� 10 �����µĺ͡�
 * ��֤�����Ĵ�û��ǰ��0
 */
public class ����֮�� {
	
	static final int[] bin = { 2, 3, 4, 5, 6, 7, 8, 9, 10 };

	public static long calc(char[] str, int b) {
		long res = 0;
		for (int i = 0; i < str.length; ++i) {
			res = res * b + (str[i] - '0');
		}
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			char[] cs = input.next().toCharArray();
			long sum = 0;
			for (int b : bin) sum += calc(cs, b);
			System.out.println(sum);
		}
		input.close();
	}

}
