package dp;

/*
 * ��һ�100ԪǮ����1,2,5,10����Ǯ�����ܹ��ж��ٶһ�����
 * */

public class ����Ǯ {

	static int[] money = { 1, 2, 5, 10 };
	static int M = 100;

	public static void violent1() {
		int counter = 0, count = 0;
		for (int ten = 0; ten <= M / money[3]; ten++) {
			for (int five = 0; five <= M / money[2]; five++) {
				for (int two = 0; two <= M / money[1]; two++) {
					for (int one = 0; one <= M / money[0]; one++) {
						++counter;
						if (ten * money[3] + five * money[2] + two * money[1] + one * money[0] == M) {
							++count;
						}
					}
				}
			}
		}
		System.out.println(count + "\tѭ���� " + counter);
	}

	public static void violent2() {
		int counter = 0, count = 0;
		for (int ten = 0; ten <= M / money[3]; ten++) {
			for (int five = 0; five <= M / money[2]; five++) {
				for (int two = 0; two <= M / money[1]; two++) {
					++counter;
					// ����ȷ��one�ĸ���
					int one = M - (ten * money[3] + five * money[2] + two * money[1]);
					if (one >= 0 && ten * money[3] + five * money[2] + two * money[1] + one * money[0] == M) {
						++count;
					}
				}
			}
		}
		System.out.println(count + "\tѭ���� " + counter);
	}

	// �ݹ�
	public static int recu(int sum, int pos) {
		// �ݹ����
		if (sum < 0 || pos < 0) {
			return 0;
		}
		// �պöһ���
		if (sum == 0) {
			return 1;
		}
		// Ҫôѡ��pos����ֵ��Ǯ(ѡ����´λ�����ѡ��pos��): (sum-money[pos], pos)
		// Ҫô��ѡ: (sum, pos-1)
		return recu(sum - money[pos], pos) + recu(sum, pos - 1);
	}

	/*
	 * ��̬�滮: sum[j]��ʾjԪ�ж����ַ�ʽ
	 * ���Էֽ��������: Ҫ�ճ�100Ԫ,�Ϳ����ȴճ�99Ԫ����98Ԫ.
	 */
	public static void dp() {
		int[] dp = new int[M + 1];
		dp[0] = 1;
		// ÿһ����ֵ������
		for (int i = 0; i < money.length; i++) {
			for (int j = money[i]; j <= M; j++) {
				/* ��Ӧ����ݹ�ʽ
				 * sum[j]����ѡ: (sum, i-1) 
				 * sum[j-money[i]]: ѡ��pos����ֵ��Ǯ(ѡ����´λ�����ѡ��pos��): (sum-money[i], i)
				 */
				dp[j] += dp[j - money[i]];
			}
		}
		System.out.println(dp[M]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		violent1();
		violent2();
		int count = recu(M, money.length - 1);
		System.out.println(count);
		dp();
	}

}
