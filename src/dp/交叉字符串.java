package dp;

/*
 * ���������ַ���s1,s2,s3���ж�s3�Ƿ�ǰ������������Ҳ��ı�s1��s2�����λ��
 * */
public class �����ַ��� {

	/*
	 * dp[i][j]��ʾs3[0..i+j-1]�Ƿ���s1[0..i]��s2[0..j]��ɣ�
	 * ����ǰs1[i]==s3[i+j-1],��dp[i-1][j]=true���ɲ�ȡs2���֣�����dp[i][j]=true
	 * ����ǰs2[j]==s3[i+j-1],��dp[i][j-1]=true���ɲ�ȡs1���֣�����dp[i][j]=true
	 * �����������dp[i][j]=false ״̬ת�Ʒ��̣� 
	 * dp[i][j] = (s1[i]==s3[i+j-1] && dp[i-1][j]) ? true : false
	 * dp[i][j] = (s2[j]==s3[i+j-1] && dp[i][j-1]) ? true : false
	 */
	public static boolean DP(String s1, String s2, String s3) {
		int n = s1.length(), m = s1.length(), h = s3.length();
		// ���Ȳ�һ
		if ((n + m) != h) {
			return false;
		}
		// start with dp[1][1]
		boolean[][] dp = new boolean[n + 1][m + 1];
		// ��ʼ�߽�����
		dp[0][0] = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// dp[i][j] = (s1[i]==s3[i+j-1] && dp[i-1][j]) ? true : false
				if (dp[i][j] || (i - 1 >= 0 && dp[i - 1][j]) && s1.charAt(i) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
					break;
				}
				// dp[i][j] = (s2[j]==s3[i+j-1] && dp[i][j-1]) ? true : false
				else if (dp[i][j] || (j - 1 >= 0 && dp[i][j - 1]) && s2.charAt(j) == s3.charAt(i + j - 1)) {
					dp[i][j] = true;
					break;
				}
				else {
					dp[i][j] = false; 
				}
			}
		}
		return dp[n][m];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		System.out.println(DP(s1, s2, s3));
	}

}
