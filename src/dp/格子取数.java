package dp;

public class ����ȡ�� {
	
	static int map[][] = {
				{0, 0, 3, 0, 2, 0},
				{0, 0, 3, 0, 0, 0},
				{0, 0, 3, 0, 0, 0},
				{0, 0, 0, 0, 4, 0},
				{0, 0, 0, 0, 4, 0},
				{0, 0, 3, 0, 0, 0}};
	static int MIN = Integer.MIN_VALUE; // ��־�����ڵ�λ��
	
	/*
	 * ��������M1��
	 * 		0 1 2 3 4 5
	 * 		1 2 3 4 5 6
	 * 		2 3 4 5 6 7
	 * 		3 4 5 6 7 8
	 * 		4 5 6 7 8 9
	 * 		5 6 7 8 9 10
	 * ��0�ߵ�10, һ����Ҫ10����2N-2�������ݲ�����ȷ��dp��״̬
	 * ���羭��3����һ�����ڱ��3��λ��
	 *     ����5����һ�����ڱ��5��λ��...
	 * 
	 * ��dp[i][j][k]��ʾ��i���У���һ���ߵ�j��λ�ã��ڶ����ߵ�k��λ��ʱ����ܺ�
	 * ��������M2��
	 * 		0 0 0 0 0 0
	 * 		1 1 1 1 1 1
	 * 		2 2 2 2 2 2
	 * 		3 3 3 3 3 3
	 * 		4 4 4 4 4 4
	 * 		5 5 5 5 5 5
	 * ���磺dp[6][2][3]��״̬����dp[5][1][2],dp[5][1][3],dp[5][2][2],dp[5][2][3]
	 * 		ѡ����һ��״̬�����ֵ�ټ���dp[6][2][3]��(6,2),(6,3)λ�õ�ֵ����,(6,2)��ʾ��6����2λ��(�ɸ��ݲ����ͱ��λ�����������)
	 * ״̬ת�Ʒ��̣� 
	 * 		dp[i][j][k] = max(dp[i-1][j-1][k-1], dp[i-1][j-1][k], dp[i-1][j][k-1], dp[i-1][j][k]) + map[i][j] + map[i][k]
	 * 
	 * ���ǵ���ĿҪ�󾭹�����ͬһ����ֻ��һ��
	 * ��j=kʱ���磺dp[6][3][3]��״̬����dp[5][2][2],dp[5][2][3],dp[5][3][3]
	 * ״̬ת�Ʒ���Ϊ��
	 * 		dp[i][j][k] = max(dp[i-1][j-1][k-1], dp[i-1][j-1][k], dp[i-1][j][k]) + map[i][j]
	 * */
	
	public static int max(int a, int b) {
		return (a < b) ? b : a;
	}
	
	public static boolean isVaild(int step, int i, int j, int N) {
		// ��ȡ������
		int y1 = step - i, y2 = step - j;
		// �ڵ�ͼ��
		return i < N && j < N && y1 < N && y2 < N
				&& i >= 0 && j >= 0 && y1 >= 0 && y2 >= 0;
	}
	
	// �жϵ�ǰ״̬λ���Ƿ�Խ�������Ч����Ч���ض�Ӧ��ֵ����Ч����MIN
	public static int check(int[][][] dp, int step, int i, int j, int N) {
		return isVaild(step, i, j, N) ? dp[step % 2][i][j] : MIN;
	}
	
	public static void DP() {
		int N = map.length;
		int S = 2 * N - 2; // �ܲ���
		int[][][] dp = new int[S + 1][N + 1][N + 1];
		for (int step = 1; step <= S; step++) {
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					dp[step][i][j] = MIN;
					if (!isVaild(step, i, j, N)) {
						continue;
					}
					if (i != j) {
						// ���ж���һ��״̬��λ���Ƿ�Խ�������Ч����Ч���־MIN
						dp[step][i][j] = max(dp[step][i][j], check(dp, step - 1, i - 1, j - 1, N));
						dp[step][i][j] = max(dp[step][i][j], check(dp, step - 1, i - 1, j, N)); 
						dp[step][i][j] = max(dp[step][i][j], check(dp, step - 1, i, j - 1, N)); 
						dp[step][i][j] = max(dp[step][i][j], check(dp, step - 1, i, j, N)); 
						// ���Ͼ������ε�ֵ
						dp[step][i][j] += map[i][step - i] + map[j][step - j];
					} 
					// ֻ��һ��
					else {
						dp[step][i][j] = max(dp[step][i][j], check(dp, step - 1, i - 1, j - 1, N));
						dp[step][i][j] = max(dp[step][i][j], check(dp, step - 1, i - 1, j, N)); 
						dp[step][i][j] = max(dp[step][i][j], check(dp, step - 1, i, j, N)); 
						// ���Ͼ������ε�ֵ
						dp[step][i][j] += map[i][step - i];
					}
				}
			}
		}
		System.out.println(dp[S][N - 1][N - 1]);
	}
	
	/*
	 * �Ż���
	 * ����ʱ�临�ӶȺͿռ临�Ӷȶ���O(n^3)������н�һ���Ż�
	 * ����ÿһ��״̬��ֻ����һ״̬�йأ����Կ�������ѭ�����飬���ռ临�ӶȽ�ΪO(n^2)
	 * �ڵ��Ƶ�dp[step]��ʱ��ֻ��Ҫdp[step-1]��״̬������step�Ĵ�Сֻ��Ҫ����2����
	 * ��stepΪż��ʱ����dp[0][i][j], Ϊ����ʱ����dp[1][i][j]
	 * */
	public static void DP1() {
		int N = map.length;
		int op = 0;
		int S = 2 * N - 2; // �ܲ���
		int[][][] dp = new int[2][N + 1][N + 1];
		for (int step = 1; step <= S; step++) {
			for (int i = 0; i < N; i++) {
				for (int j = i; j < N; j++) {
					// ��stepΪż��ʱ����dp[0][i][j], Ϊ����ʱ����dp[1][i][j]
					op = step % 2;
					dp[op][i][j] = MIN;
					if (!isVaild(step, i, j, N)) {
						continue;
					}

					if (i != j) {
						// ���ж���һ��״̬��λ���Ƿ�Խ�������Ч����Ч���־MIN
						dp[op][i][j] = max(dp[op][i][j], check(dp, step - 1, i - 1, j - 1, N));
						dp[op][i][j] = max(dp[op][i][j], check(dp, step - 1, i - 1, j, N)); 
						dp[op][i][j] = max(dp[op][i][j], check(dp, step - 1, i, j - 1, N)); 
						dp[op][i][j] = max(dp[op][i][j], check(dp, step - 1, i, j, N)); 
						// ���Ͼ������ε�ֵ
						dp[op][i][j] += map[i][step - i] + map[j][step - j];
					} 
					// ֻ��һ��
					else {
						dp[op][i][j] = max(dp[op][i][j], check(dp, step - 1, i - 1, j - 1, N));
						dp[op][i][j] = max(dp[op][i][j], check(dp, step - 1, i - 1, j, N)); 
						dp[op][i][j] = max(dp[op][i][j], check(dp, step - 1, i, j, N)); 
						// ���Ͼ������ε�ֵ
						dp[op][i][j] += map[i][step - i];
					}
				}
			}
		}
		System.out.println(dp[S % 2][N - 1][N - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP1();
	}

}
