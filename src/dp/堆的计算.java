package dp;

import java.util.Scanner;

/*
 * ����֪������ N ��Ԫ�صĶѿ��Կ�����һ�ð��� N ���ڵ����ȫ�������� 
 	ÿ���ڵ���һ��Ȩֵ������С������˵�����ڵ��Ȩֵһ��С�����ӽڵ��Ȩֵ��
	���� N ���ڵ��Ȩֵ�ֱ��� 1~N���������һ���ж����ֲ�ͬ��С������
	������� N=4 ������ 3 �֣�
	 1
	/ \
	2 3
	/
	4
	 
	 1
	/ \
	3 2
	/
	4
	 
	 1
	/ \
	2 4
	/
	3
	�����������ܳ������ͷ�Χ����ֻ��Ҫ���������� 1000000009 ������
 */
public class �ѵļ��� {
	
	static final int mod = 1000000009;

	/*
	 * dp[i]��ʾ��iΪ�ڵ������е�С���ѵĸ���
	 * 
	 */
	public static int Dp(int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n + 1];
		// initialize array
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i; 
		}
		// left child: 2*n,  right child: 2*n+1
		
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(Dp(n));
		input.close();
	}

}
