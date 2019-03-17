package dp;

import java.util.Scanner;

/*
 * ��������4 13 14 1 2 3,����4 14 2 3��14 1 2 3��������������
 * Ҫ��������еĲ�ͬ�����еĸ�������Щ����������ͬ�ģ�����1��
 * δAC����Ҫ����һЩ����
 */
public class �����и��� {

	static int M = 1000000007;
	
	/*
	 * �����и�����ͬ������a��1 2 3 4�����Ӧ�������и���Ϊ��1 3 7 15
	 * �õ����ƹ�ʽ1��dp[i] = 2 * dp[i-1] + 1, a[k]!=a[i]
	 * Ҳ������ô��⣺ Ҫ��dp[i]�������и������޷Ǿ�����dp[i-1]�ĸ��������ӵ�k����a[k]
	 * ���磬������a: 1���¼���һ����ͬ�������е�Ԫ�أ� 2��ʱ����ʱ��Ҫ��dp[1]=?
	 * ������֪dp[0]=1�������������Գ�һ�ɣ����׵ã�dp[1]=dp[0]+1������2����������Ԫ�ؼ�����һ����
	 * ��ʱ��2��û����1������ϳ��µ������У�����Ҫ��dp[i-1]��ÿ�����к��涼����2��������¼���2�����
	 * ���� dp[i] = (dp[i-1] + 1) + dp[i-1], a[k]!=a[i]
	 * 
	 * ���¼����Ԫ��������a: 1 2 3 ��ĳ����ͬ��ʱ�򣬼����¼����Ԫ��Ϊa[k]=2
	 * �����ҵ���a[k]�������ͬԪ��λ��t����ô������dp[t-1]�������a[k]Ԫ�ؾͺ�t����Ԫ���ظ���
	 * ���Լ���dp[t-1]֮ǰ����Ͼ����ˣ� 
	 * ���� dp[i] = 2 * dp[i-1] - dp[t-1], a[k]=a[t]
	 */
	public static int DP(int[] arr, int n) {
		int[] dp = new int[n + 1];
		// �����k��Ԫ����ͬ�������index
		int[] mark = new int[n + 1];
		// initialize
		for (int i = 0; i < mark.length; i++) {
			mark[i] = -1; 
		}
		// ����Ԫ���Գ�һ��
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			// seek nearest element 
			for (int j = i - 1; j >= 1; j--) {
				if (arr[i] == arr[j]) {
					mark[i] = j; 
					break;
				}
			}
			// dp[i] = 2 * dp[i-1] + 1, a[k]!=a[i]
			if (mark[i] == -1) {
				dp[i] = (2 * dp[i - 1] + 1) % M;
			}
			// dp[i] = 2 * dp[i-1] - dp[t-1], a[k]=a[t]
			else {
				int t = (mark[i] - 1 >= 1) ? dp[mark[i] - 1] : 0;  // ��ֹԽ��
				dp[i] = (2 * dp[i - 1] - t + M) % M; // tΪ���ಿ��
			}
		}
//		System.out.println(Arrays.toString(dp));
		return dp[n] % M;
	}
	
	// optimizer
	public static int DP1(int[] arr, int n) {
		int[] dp = new int[n + 1];
		// �����k��Ԫ����ͬ�������index
		int[] mark = new int[1000000];
		// ����Ԫ���Գ�һ��
		dp[1] = 1;
		mark[arr[1]] = 1;
		for (int i = 2; i <= n; i++) {
			// dp[i] = 2 * dp[i-1] + 1, a[k]!=a[i]
			if (mark[arr[i]] == 0) {
				dp[i] = (2 * dp[i - 1] + 1) % M;
			}
			// dp[i] = 2 * dp[i-1] - dp[t-1], a[k]=a[t]
			else {
				// �������ŵ�ʱ��ȡģʱҪ��M��ȡģ��
				dp[i] = (2 * dp[i - 1] - dp[mark[arr[i]] - 1] + M) % M;
			}
			mark[arr[i]] = i;
		}
//		System.out.println(Arrays.toString(dp));
		return dp[n] % M;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr = {4, 4, 14, 1, 3, 5};
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = input.nextInt(); 
		}
		System.out.println(DP(arr, n));
		System.out.println(DP1(arr, n));
		input.close();
	}

}
