package dp;

/*
 * ��һ�������� n, �������ٶ��ٸ���ȫƽ����(����1, 4, 9...)�ĺ͵���n��
 * ����: 12
 * ���: 3
 * ����: 4 + 4 + 4
 * ����: 13
 * ���: 2
 * ����: 4 + 9
 */
public class ����ƽ�� {
	
	/*
	 * dp[i]��ʾ����i������ȫƽ�����ĸ���
	 * ��ʼdp[1]=1
	 * �磺2,���Էֽ��1+1��3��1+1+1��4:2+2
	 * ��״̬ת�Ʒ��̣�dp[i] = min(i, dp[i-j*j]+1),j<=sqrt(i)
	 */
    public static int numSquares(int n) {
        // write your code here
    	int[] dp = new int[n + 1];
    	dp[1] = 1;
    	for (int i = 2; i <= n; i++) {
    		// Ѱ����Сֵ
			int minimum = i;
			for (int j = 1; j <= Math.sqrt(i); j++) {
				minimum = min(minimum, dp[i - j * j] + 1);
			}
			dp[i] = minimum; 
		}
    	return dp[n];
    }
    
    public static int min(int a, int b) {
    	return (a < b) ? a : b;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(13));
	}

}
