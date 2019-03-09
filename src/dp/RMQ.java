package dp;

/*
 * RMP(range minimum query), ������ֵ��ѯ
 * ��������ĳ������,�����������Сֵ��λ��
 * */
public class RMQ {

	// common method, ��ѯm�ε�ʱ�临�Ӷ�ΪO(nm)
	public static int violence(int[] arr, int i, int j) {
		int index = -1, min = Integer.MAX_VALUE;
		for (int k = i; k <= j; k++) {
			if (min > arr[k]) {
				min = arr[k];
				index = k;
			}
		}
		return index;
	}

	/*
	 * dp[i][j] ��ʾarr[i]~A[j]����Сֵ ��Initialize����dp[i][j]=arr[i] Ȼ�󷽳�: dp[i][j] =
	 * min(dp[i][j-1], arr[j]) �����������i,j֮�����Сֵ���±�ֵ�洢��dp�� ��ѯm�ε�ʱ�临�Ӷ�ΪO(n^2+m)
	 */
	public static int[][] Dp(int[] arr, int n) {
		// save index
		int[][] dp = new int[n][n];
		// initialization
		for (int i = 0; i < n; i++) {
			dp[i][i] = i;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// dp[i][j] = min(dp[i][j-1], arr[j])
				if (arr[dp[i][j - 1]] < arr[j]) {
					dp[i][j] = dp[i][j - 1];
				} else {
					dp[i][j] = j;
				}
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 4, 3, 1, 6, 7, 8, 9, 1, 7 };
		int i = 2, j = 7;
		System.out.println(violence(arr, i, j));
		int[][] dp = Dp(arr, arr.length);
		System.out.println(dp[i][j]);
	}

}
