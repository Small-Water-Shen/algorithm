package dp;

import java.util.Scanner;

/*
 * �ڡ����˵��򡷵�Ӱ�У���˵������ľ��֮���ƶ��˵����뿪ľ�ǣ����Ǵ�ը�ݻ��˵����ϴ󲿷ֵ����Ƿ�������
 * ������һ��չ��ȫ���Ծ�Ԯ����ʱ��MOSS�Ѿ����ջ٣����ڸ�����ÿֻ��Ԯ�ӵ�Ŀ�귢�����ı���Լ���ֻ��Ԯ���ڹ涨ʱ���ڳɹ���Ԯ�ĸ��ʣ�
 * ����������k�����Ƿ������ܹ��õ�����������Ϊ����ᱻ���ȡ��������һ�����򣬰����������������㡣
 * ��������:
 * ��һ�и���N��M��K��N���������ɳ��ľ�Ԯ��������M�����ݻٵ����Ƿ�������K����������Ҫ���������Ƿ�����������(1<=N<=1e5,K<=M<=2000)
 * ������N�У�ÿ�и���ai,pi���ֱ�����i֧��Ԯ�ӵ�Ŀ�귢�����ı����ai����Ԯ�ɹ��ĸ���Ϊpi��(1<=ai<=M,0<=pi<=1)
 * ֻҪ��һֻ��Ԯ��˳���ִ�����Ƿ�����������Ϊ�÷��������ɹ�������
 * �������: ������򱻾�Ԯ�ɹ��ĸ��ʣ����ϸ���3λС����
 * ����
 * 3 2 2
 * 1 1
 * 1 1
 * 2 0.5
 * ��� 0.500
 */
public class ����ʽ��Ԯ {
	
	static int n, k, m;
	static double[] pro = new double[2010]; // ÿ���������Ĳ��ɹ���
	static double[][] dp = new double[2010][2010];
	
	/*
	 * ��Ϊһ�����������Ա���������Ԯ�������ܵĳɹ���=1-��������ʧ����֮��
	 * dp[i][j]��ʾ����i�����������Ѿ���Ԯ��j��, ֱ�����dp[M][K]����
	 * ����: ����1�����������Ѿ���Ԯ��1������ô
	 * �����Ԯ�ɹ��ͱ��2�����������Ѿ���Ԯ��2��
	 * �����Ԯʧ�ܣ���Ϊ2�����������Ѿ���Ԯ��1��
	 * ״̬ת�Ʒ���: dp[i][j] = dp[i-1][j-1]*pro[i] + dp[i-1][j]*(1-pro[i])
	 */
	public static void DP(Scanner input) {
		if (k == 0) {
			System.out.println("1.000");
			return;
		}
		if (n < k) {
			System.out.println("0.000");
			return;
		}
		// initialize
		for (int i = 1; i <= m; ++i) pro[i] = 1; 
		for (int i = 1; i <= n; i++) {
			int id = input.nextInt();
			double probably = input.nextDouble();
			pro[id] *= (1 - probably); // �õ�������id��ʧ����
		}
		// ��������������ľ�Ԯ�ɹ���
		for (int i = 1; i <= m; i++) pro[i] = 1 - pro[i];
		// initialize
		dp[0][0] = 1;
		for (int i = 1; i <= m; i++) {
			// j=0��Ϊʧ��
			dp[i][0] = dp[i - 1][0] * (1 - pro[i]);
			for (int j = 1; j <= m; j++) {
				dp[i][j] = dp[i - 1][j - 1] * pro[i] + dp[i - 1][j] * (1 - pro[i]);
			}
		}
		double ant = 0;
		for (int i = k; i <= m; i++) ant += dp[m][i];
		System.out.println(String.format("%.3f", ant));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();
		DP(input);
		input.close();
	}

}
