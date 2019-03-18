package game_theory;

/*
 * �� n ��Ӳ���ų�һ���ߡ���������������������������� 1 �� 2 ��Ӳ�ң�ֱ��û��Ӳ��Ϊֹ��
 * �����������õ���Ӳ�ҵ��ܼ�ֵ, ��ֵ���߻�ʤ
 * ���ж� ������� ��ʤ���Ǳذ�? (���������߶��㹻����)
 * ����ʤ, ���� true, ���򷵻� false.
 * ����: [1, 2, 2]
 * ���: true
 * ����: �������ֱ����������Ӳ�Ҽ���.
 * ����: [1, 2, 4]
 * ���: false
 * ����: ����������һ����������, ���ֿ�������, Ȼ���ܼ�ֵ����
 */
public class Ӳ���ų���2 {
	
	/*
	 * dp[i]��ʾ��values[i..len]ʱ�����õ������ֵ
	 * ����һ��:
	 * dp[len]�϶�û�п����õ��� => dp[len]=0
	 * dp[len-1]��һ�������� => dp[len-1]=values[len-1]
	 * dp[len-2]������������ => dp[len-2]=values[len-1]+values[len-2]
	 * dp[len-3]������������,�������һ��,�Է��ͻ���������,��������������õ� => dp[len-3]=values[len-3]+values[len-2]
	 * dp[len-4]���ĸ�������,��������һ����������:
	 *          ����1��: ���ֿ�������һ����������,���ֿ϶��������,��������,��������ֻ������С���Ǹ�(����ͼ�������)
	 *          		��: dp[i] = values[i] + min(dp[i+2], dp[i+3])
	 *                                            �ڶ���������  ��һ��
	 *          ����2��: ����Ҳ��������һ����������,ͬ�������,���ֿ϶�������������һ��(����),�����ҷ�ֻ������С��
	 *          		��: dp[i] = values[i] + values[i+1] + min(dp[i+3], dp[i+4])
	 *                                                         �ڶ�����һ��   û����
	 * Ȼ��ȡ��������µ����ֵ
	 */
	public static boolean game(int[] values) {
		int len = values.length;
		if (len <= 2) {
			return true;
		}
		int[] dp = new int[len + 1];
		// initialize
		dp[len] = 0;
		dp[len - 1] = values[len - 1]; // ֱ���������һ��
		dp[len - 2] = values[len - 1] + values[len - 2]; // ֱ�������������
		dp[len - 3] = values[len - 3] + values[len - 2]; // �������һ��,�Է��ͻ���������,��������������õ� 
		if (len == 3) {
			return dp[0] > values[len - 1] ? true : false;
		}
		// ����
		for (int i = len - 4; i >= 0; --i) {
			if (!isValid(i, len)) {
				continue;
			}
			int getOne = values[i] + Math.min(dp[i + 2], dp[i + 3]);
			int getTwo = values[i] + values[i + 1] + Math.min(dp[i + 3], dp[i + 4]);
			dp[i] = Math.max(getOne, getTwo); 
		}
		// get summary
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += values[i];
		}
		int opponent = sum - dp[0]; // opponent's values
		return dp[0] > opponent;
	}
	
	public static boolean isValid(int i, int len) {
		return (i + 1 <= len && i + 2 <= len && i + 3 <= len && i + 4 <= len);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {1, 2, 2, 4};
		System.out.println(game(values));
	}

}
