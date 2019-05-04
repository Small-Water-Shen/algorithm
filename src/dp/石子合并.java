package dp;

import java.util.*;

/*
 * ��n��ʯ���ų�һ�ţ���i��ʯ����ai��ʯ�ӡ�
 * ÿ�Σ������ѡ���������ڵ�����ʯ�ӽ��кϲ����ϲ����ʯ������Ϊ����ʯ�ӵĺͣ�
 * ���ĵ������ȼ�������ʯ����ʯ�����ٵ��Ǹ������ʣ������е�ʯ�Ӻϲ���һ�ѣ�
 * �������ĵ�������С�Ƕ��٣�
 */
public class ʯ�Ӻϲ� {

	static int n;
	static int[] data;

	// ˼�룺dp[i][j]��ʾ��ǰ�ϲ�����С���ۣ�����Ϊ��i��ʼ����Ϊj������ϲ�
	public static void DP() {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		data = new int[n * n];
		int[][] dp = new int[n + 1][n + 1];
		int[][] sum = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			data[i] = input.nextInt();
		// ��ʼ��sum����ʾ��i��ʯ�ӵ���j��ʯ��ȫ���ϲ�����ʯ����
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum[i][j] = sum[i][j - 1] + data[i + j - 1];
			}
		}
		for (int len = 2; len <= n; len++) {
			for (int i = 1; i <= n - len + 1; i++) {
				dp[i][len] = Integer.MAX_VALUE;
				for (int j = 1; j < len; j++) {
					dp[i][len] = Math.min(dp[i][len], dp[i][j] + dp[i + j][len - j] + sum[i][len]);
				}
			}
		}
		System.out.println(dp[1][n]);
		input.close();
	}

	public static void DP1() {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		data = new int[n + 1];
		int[][] dp = new int[n + 1][n + 1];
		int[] sum = new int[n * n];
		for (int i = 1; i <= n; i++) {
			data[i] = input.nextInt();
			sum[i] = sum[i - 1] + data[i];
		}

		System.out.println(dp[1][n]);
		input.close();
	}

	/*
	 * �������ƶ�����������ƶ������ѣ������ظ���ε��ƶ��öѣ���ɲ���Ҫ����ʧ ����ֱ�ӿ��Խ����Ѹ����Ķ������Ѻϲ����ɣ�ת��Ϊ���ܵ�ʯ����-���ֵ
	 */
	public static void reasoning() {
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		while (T-- > 0) {
			int n = input.nextInt();
			long sum = 0;
			long max = 0;
			for (int i = 0; i < n; i++) {
				long a = input.nextLong();
				sum += a;
				max = (max < a) ? a : max;
			}
			System.out.println(sum - max);
		}
		input.close();
	}

	public static void main(String[] args) {
		DP();
//    	DP1();
		reasoning();
	}
}
