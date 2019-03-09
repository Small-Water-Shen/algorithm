package dp;

import java.util.Scanner;

/*
 * �����߶�Ϊn�������Σ� ������ߵ��¾���������֮�����ֵ��
 * ÿ��ֻ���ߵ���һ�����ڵ����ϡ�
 * �磺
 *           5
 *          8 4
 *         3 6 9
 *        7 2 9 5
 * ���ŷ����ǣ�5+8+6+9=28
 * */
public class ����ȡ�� {
	
	public static int max(int a, int b) {
		return (a < b) ? b : a;
	}

	/* ״̬ת�Ʒ��̣�dp[i][j] += min(dp[i-1][j], dp[i-1][j-1]) + map[i][j]
	 * ��ǰ״̬��dp[i-1][j], dp[i-1][j-1]����
	 * ��Ϊֱ��ʹ��Դ������е��ƣ�ʡȥ����������ͳ�ʼ��
	 * ���Է���Ϊ��map[i][j] = min(map[i-1][j], map[i-1][j-1]) + map[i][j]
	 */
	private static void DP1(int[][] map, int deep) {
		// TODO Auto-generated method stub
		// �ӵڶ��п�ʼ������index��1��ʼ��ֹԽ��
		for (int i = 2; i <= deep; i++) {
			for (int j = 1; j <= i; j++) {
				//�Ƚ����������������ļ��ϸ��ڵ�
				map[i][j] = max(map[i - 1][j], map[i - 1][j - 1]) + map[i][j]; 
			}
		}
		/* ���ֵ�϶�����dp[deep][deep]
		 * ������Ҫ�ҳ����һ�е����ֵ
		 */
		int maxValue = 0;
		for(int i = 1; i <= deep; i++){
			maxValue = (map[deep][i] > maxValue) ? map[deep][i] : maxValue;
		}
		System.out.println(maxValue);
	}

	/*
	 * �Ż�ʱ�临�Ӷ�
	 * ���õ��˵ķ���
	 * ״̬ת�Ʒ��̣� dp[i-1][j] += max(dp[i][j], dp[i][j+1])
	 * dp[i-1][j]����һ��   dp[i][j]����һ���Ӧ��λ��  dp[i][j+1]����һ�ε����½�λ��
	 * */
	public static void DP2(int[][] map, int deep) {
		for (int i = deep; i >= 1; --i) {
			for (int j = 1; j < i; j++) {
				map[i - 1][j] +=  max(map[i][j], map[i][j + 1]);
			}
		}
		System.out.println(map[1][1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int deep = input.nextInt();
		int[][] map = new int[deep + 1][deep + 1];
		/* ���뵽map������
		 * 5
		 * 84
		 * 369
		 * 7295
		 * */
		for (int i = 1; i <= deep; i++) {
			for (int j = 1; j <= i; j++) {
				map[i][j] = input.nextInt();
			}
		}
		// ��map���룬��ı�map��ֵ
		DP1(map, deep);
		DP2(map, deep);
		input.close();
		System.exit(0);
	}

}
