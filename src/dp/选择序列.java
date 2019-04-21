package dp;

import java.util.Scanner;

/*
 * ����һ������ΪN������a1,a2,��,aN����������N��Ԫ����ѡ��һЩ�����Բ�ѡ������ȫѡ����
 * ʹ�ö�������1��i<N��ai��ai+1����ͬʱѡ����ѡ�������ĺ�����Ƕ��١�
 * ��һ��һ��������T����ʾ����������ÿ�����ݵĵ�һ��һ��������N��������һ��N��������a1,a2,��,aN��
 * T�У�ÿ��һ����������ʾÿ�����ݵĴ𰸡�
 */
public class ѡ������ {

	/*
	 * ��������λ�ò�������ȡ,����һλ�õ����ֵ�ǵ�ǰλ�����ֵ����״̬
	 * dp[i]��ʾ��i�������ֵ,
	 * ״̬ת�Ʒ���: dp[i] = max(d[i-1], arr[i]+dp[i-2])
	 * Ϊ����Ӧ����, arr����index��Ҫ��1��ʼ
	 */
	public static int dp(int[] arr, int len) {
		int[] dp = new int[len + 1];
		dp[1] = arr[1];
		for (int i = 2; i <= len; i++) {
			dp[i] = Math.max(dp[i - 1], arr[i] + dp[i - 2]); 
		}
		return dp[len];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int i = 0; i < T; i++) {
			int n = input.nextInt();
			int[] arr = new int[n + 1];
			for (int j = 1; j <= n; j++) {
				arr[j] = input.nextInt(); 
			}
			System.out.println(dp(arr, n));
		}
		input.close();
	}

}
