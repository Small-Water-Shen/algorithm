package dp;

import java.util.Scanner;

/*
 * ����һ��ֻ���Ǹ�������m*n�����ҵ�һ�������Ͻǵ����½ǵĿ���ʹ���ֺ���С��·����
 * ����ͬһʱ��ֻ�����»��������ƶ�һ��
 * */
public class ��С·���� {
	
	static int MAX = 99999;
	
	public static int min(int a, int b) {
		return (a < b) ? a : b;
	}
	
	// �ж�Խ��
	public static boolean isVaild(int i, int j, int m, int n) {
		return i >= 0 && j >= 0 && i < m && j < n; 
	}
	
	// �ж��Ƿ�Խ�粢����֮
	public static int check(int[][] dp, int i, int j, int m, int n) {
		return isVaild(i, j, m, n) ? dp[i][j] : MAX;
	}
	
	/*
	 * dp[i][j]��ʾ��i��j��λ����С·�����ܺ�
	 * ״̬ת�Ʒ��̣�dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + map[i][j]
	 * */
	public static void DP(int[][] map, int m, int n) {
		// TODO Auto-generated method stub
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int down = check(dp, i - 1, j, m, n);
				int right = check(dp, i, j - 1, m, n);
				if (down == MAX && right == MAX) {
					dp[i][j] += map[i][j]; 
				} else {
					dp[i][j] += min(down, right) + map[i][j]; 
				}
			}
		}
		System.out.println(dp[m - 1][n - 1]);
	}
	
	/*
	 * �Ż�Ϊһά
	 * dp[i][j]ֻ��dp[i-1][j], dp[i][j-1]�й�
	 * ��dp[i]������ǰ����Сֵ
	 * dp[i] = min(dp[i-1], dp[i] + map[i][j])
	 */
	public static void DP1(int[][] map, int m, int n) {
		// TODO Auto-generated method stub
		int[] dp = new int[n];
		// init
		dp[0] = map[0][0];
		for (int j = 1; j < n; j++) {
			dp[j] =  dp[j - 1] + map[0][j];
		}
		// dp[j]���ڱ�����һ�е�ֵ
		for (int i = 1; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					// down
					dp[j] = map[i][j] + dp[j];  
				}
				// can right or down
				else {
					dp[j] = map[i][j] + min(dp[j - 1], dp[j]);  
				}
			}
		}
		System.out.println(dp[n - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int m = input.nextInt(), n = input.nextInt();
		int[][] map = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = input.nextInt(); 
			}
		}
		DP(map, m, n);		
		DP1(map, m, n);
		input.close();
	}

}
