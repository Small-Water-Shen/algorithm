package dp;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ����һ�����϶��־�������⣺�ø����ļ���Ǯ�Ҵճ�ĳ��Ǯ����һ������ж��ַ�ʽ��
 * ���磺������6��Ǯ����ֵΪ2��5��10��20��50��100��������15Ԫ��������5��2��1��5����3��5��
 * �ֻ���1��5��1��10���ȵȡ���Ȼ��������Ҫ2��Ǯ�ң���1��5��1��10�����ܴճ�15Ԫ��
 * ���������ǣ����������ɸ�������ͬ��Ǯ����ֵ��
 * �����������Ҫ���ٸ�Ǯ�Ҳ��ܴճ�ĳ��������Ǯ�����������Ǯ����ֵ��
 * �����ܴճ��������impossible!����
 * 
 *  Input
	��һ��������һ��������T��������T��������ݣ��ڶ����������ǵ�һ��������ݣ�
	���У��ڶ����Ǹ�����Ǯ���������е�1��������n����Ǯ����ֵ������������n������������ÿ����ֵ�����������ġ��������ǵڶ����������...�Դ����ơ�
	Ouput
	�����������Ҫ��Ǯ���ܸ��������ŷֱ����ÿ��Ǯ�ҵ���ֵ x ������� y����ʽΪ x(y)
	Sample Input
	3
	15
	4 2 5 10 20
	21
	3 5 10 20
	36
	5 2 5 10 20 50
	Sample Output
	2 10(1) 5(1)
	impossible!
	5 20(1) 10(1) 2(3)
 * */

public class ����Ǯ���� {

	final static int N = 10000;

	/*
	 * �оֲ��⣬ ���磺��17�� ��1 3 8 10��ֵ
	 */
	public static int[] greedy(int[] money, int value) {
		Arrays.sort(money);
		int len = money.length;
		// �±������ֵ�� ֵ������Ŀ.
		// 0λ��������
		int[] result = new int[money[len - 1] + 1];
		boolean flag = false;
		for (int i = len - 1; i >= 0; i--) {
			if (money[i] > value)
				continue;
			if (value % money[i] == 0) {
				flag = true;
			}
			result[money[i]] = value / money[i];
			result[0] += value / money[i];
			value %= money[i];
			if (flag)
				break;
		}
		if (value != 0) {
			result[0] = -1;
		}
		return result;
	}

	// �ݹ�
	public static int dg(int[] coints, int n, int index, int money) {
		// �պô���Ǯ��
		if (money == 0) {
			return 0;
		}
		// �߽�����
		if (index >= n || money < 0 || money < coints[index]) {
			return N; // ������Integer.Max�ᳬ
		}
		// ��ǰǮ���պõ�����ֵ��, ��պ�
		for (int i = 0; i < n; i++) {
			if (coints[i] == money) {
				return 1;
			}
		}
		/*
		 * �ݹ�, ��ȡ�벻ȡindexλ�õ���ֵ��, ѡһ��������С�� ����ѡ��indexλ�õ���ֵ������ѡ��, ����index��������
		 */
		return Math.min(dg(coints, n, index + 1, money), dg(coints, n, index, money - coints[index]) + 1);
	}

	/*
	 * ����dp ״̬ת�Ʒ���: dp[index] = Math.min(dp[index], dp[index-coints[j]] + 1)
	 */
	public static void dp(int[] coints, int money) {
		int len = coints.length;
		int[] dp = new int[money + 1]; // �±����ǰǮ��, ����ֵ����Ǯ��
		int[] records = new int[money + 1]; // ��¼������Щ��ֵ
		// ��1Ԫ��ʼ��
		for (int i = 1; i <= money; i++) {
			int min = N;
			int temp = -1;
			for (int j = 0; j < len; j++) {
				if (coints[j] <= i) {
					if ((1 + dp[i - coints[j]]) < min && dp[i - coints[j]] != -1) {
						min = 1 + dp[i - coints[j]];
						temp = coints[j];
					}
				}
			}
			// ���ܴյĸ�ֵΪ-1, ��Ϊ���ܴճ�
			dp[i] = (min != N) ? min : -1;
			records[i] = temp;
		}
		if (dp[money] == -1) {
			System.out.println("impossible!");
		} else {
			// ���
			System.out.print(dp[money] + " ");
			int[] counts = new int[money + 1];
			int money_t = money;
			while (money_t > 0) {
//				System.out.print(records[money]+" ");
				counts[records[money_t]]++;
				money_t = money_t - records[money_t];
			}
			for (int k = 0; k <= money; k++) {
				if (counts[k] != 0) {
					System.out.print(k + "(" + counts[k] + ") ");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int value = input.nextInt();
		int n = input.nextInt();
		int[] coints = new int[n];
		for (int i = 0; i < n; i++) {
			coints[i] = input.nextInt();
		}
		// ��̬�滮
		dp(coints, value);
		// ̰��, ����ȫ
//		int[] count = greedy(money, value);
//		if (count[0] == -1) {
//			System.out.println("impossible!");
//		} else {
//			System.out.print(count[0] + " ");
//			for (int i = 1; i < count.length; i++) {
//				if (count[i] != 0) {
//					System.out.print(i + "(" + count[i] + ") ");
//				}
//			}
//		}
		// �ݹ�
//		int count = dg(coints, n, 0, value);
//		System.out.println((count == N) ? "impossible!" : count);
		input.close();
	}
}
