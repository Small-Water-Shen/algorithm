package dp;

import java.util.Scanner;

public class ��Ǯ���� {

	static int[] code = { 1, 3, 5 };// Ӳ����ֵΪ1Ԫ��3Ԫ��5Ԫ
	// ��̬�滮

	public static void Dp(int x) {// ���±��ʾ�۸�ֵ��ʾ��Ҫ���ٸ�Ӳ��
		int[] dp = new int[x + 1];
		int[] path = new int[x + 1];
		// init
		int len = 0;
		for (int i = 0; i < dp.length; i++)
			dp[i] = i;
		for (int i = 2; i < x + 1; i++) {
			int value = 0;
			for (int k = 0; k < code.length; k++) {
				/*
				 * //����ֵ if (code[k]<=i) { dp[i] = Math.min(dp[i-code[k]]+1,
				 * dp[i]); }
				 */
				// ���Ž�
				if (code[k] <= i && dp[i] > (dp[i - code[k]] + 1)) {
					dp[i] = dp[i - code[k]] + 1;
					value = code[k];// ����ֵ
				}
			}
			path[len++] = value;
		}
		System.out.println("�չ�" + x + "Ԫ������Ҫ " + dp[x] + " ��Ӳ��");
		System.out.print("��Ӧ��Ӳ��Ϊ��");
		// ���ݷ���·��
		len--;
		while (len > 0) {
			System.out.print(path[len] + " ");
			len -= path[len];
		}
		System.out.println();
		/*
		 * ̰�ķ���·�� int[] path = new int[dp[x]]; int len = 0; int value = x; int k
		 * = dp[x]; while (k > 0 && value != 0) { for (int
		 * i=code.length-1;i>=0;i--) { if (value >= code[i]) { path[len++] =
		 * code[i]; value -= code[i]; k--; break; } } } //�������·�� for (int
		 * i=len-1;i>=0;i--) { System.out.print(path[i]+" "); }
		 * System.out.println();
		 */
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			int x = input.nextInt();
			if (x == 0) {
				System.out.println("Input Error!");
				continue;
			}
			Dp(x);
		}
		input.close();
	}
}
