package dp;


/*
 * ����һ��M��N�ľ���,�ҳ��˾����һ���Ӿ���,Ҫ����Ԫ��֮��������,���������ֵ
 * */
public class ����Ӿ���� {

	static int[][] data = { { 0, -2, -7, 0 }, { 9, 2, -6, 2 }, { -4, 1, -4, 1 }, { -1, 8, 0, -2 } };

	private static void Violence() {
		// TODO Auto-generated method stub
		int M = data.length, N = data[0].length;
		int lenSum = M * N;
		int maxSum = Integer.MIN_VALUE, curSum;
		for (int i = 0; i < lenSum; i++) {
			for (int j = i; j < lenSum; j++) {
				curSum = 0;
				for (int k = i; k <= j; k++) {
					curSum += data[k / M][k % N];
				}
				maxSum = (curSum > maxSum) ? curSum : maxSum;
			}
		}
		System.out.println(maxSum);
	}

	private static void initialize(int[] dp) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 0;
		}
	}

	private static int oneDime(int[] dp, int n) {
		// TODO Auto-generated method stub
		int max = 0, curSum = 0;
		for (int i = 0; i < dp.length; i++) {
			if (curSum >= 0) {
				curSum += dp[i];
			} else {
				curSum = dp[i];
			}
			max = (curSum > max) ? curSum : max;
		}
		return max;
	}

	/*
	 * ����άѹ��ת��Ϊһά, ��ÿ���Ӿ����ۼӵ�����dp�� ��������������������к͵ķ���: sum[i]��ʾ��i��β�������еĺ� �Ե�i��Ԫ��������ѡ��:
	 * Ҫô����ǰ���������, Ҫô��Ϊ�������еĿ�ͷ ״̬ת�Ʒ��̣�sum[i] = math.max(sum[i-1]+data[i], data[i])
	 */
	private static void dp() {
		// TODO Auto-generated method stub
		int M = data.length, N = data[0].length;
		int max = Integer.MIN_VALUE;
		int[] dp = new int[N];
		for (int i = 0; i < M; i++) { // �������Ͻ�
			// ��ʼ���Ӿ���
			initialize(dp);
			for (int j = i; j < M; j++) { // �����Ӿ������
				for (int k = 0; k < N; k++) { // �����Ӿ������
					dp[k] += data[j][k];
				}
				int curMax = oneDime(dp, N);
				max = (curMax > max) ? curMax : max;
			}
		}
		System.out.println(max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Violence();
		dp();
	}

}
