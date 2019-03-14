package dp;

import java.util.Scanner;

/*
 * ������������¥�ݣ���Ҫn������ܵ��ﶥ������ÿ����ֻ����һ�����������������ж����ֲ�ͬ�ķ�������¥������
 * ��:3��: 1 1 1, 1 2, 2 1 => 3��
 * */
public class ��¥�� {
	
	public static int func(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return func(n - 1) + func(n - 2);
	}
	
	/*
	 * ��ǰn���Ĵ�����n-1,n-2����״̬����(����쳲���������)
	 * ��̬ת�Ʒ���: dp[i] = dp[i-1] + dp[i-2])
	 */
	public static int Dp(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int sum = 0, step1 = 1, step2 = 2;
		for (int i = 3; i <= n; i++) {
			sum = step1 + step2;
			step1 = step2;
			step2 = sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
//		System.out.println(func(n));
		System.out.println(Dp(n));
		input.close();
	}

}
