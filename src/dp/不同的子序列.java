package dp;

/*
 * �����ַ���S���ַ���T������S�Ĳ�ͬ����������T���ֵĸ�����
 * �������ַ�����ԭʼ�ַ���ͨ��ɾ��һЩ(�����)������һ���µ��ַ�����
 * ���Ҷ�ʣ�µ��ַ������λ��û��Ӱ�졣(���磬��ACE���ǡ�ABCDE�����������ַ���,����AEC������)��
 * ����S = "rabbbit", T = "rabbit"
 * ���� 3 
 * ������սʱ�临�Ӷ�ΪO(n2)���ռ临�Ӷ�ΪO(n)���㷨��
 */
public class ��ͬ�������� {

	/*
	 * dp[i][j]��ʾS��ǰi���ַ��У�T��ǰj���ַ����ֵĴ��� 
	 * ��֪�������Ƿ���ȣ�dp[i][j]=dp[i-1][j] (�Ѿ�ƥ��ɹ���ǰi-1���ַ����̶���) 
	 * dp[i][j] = (S[i]==T[j]) ? dp[i-1][j]+dp[i-1][j-1] : dp[i-1][j];
	 */
	public static int DP(String S, String T) {
		// TODO Auto-generated method stub
		int sLen = S.length(), tLen = T.length();
		int[][] dp = new int[sLen + 1][tLen + 1];
		// initialize
		for (int i = 0; i <= sLen; i++) {
			dp[i][0] = 1; // ��Ŀ�괮�ǿմ���ֻ��һ��ƥ��
		}
		for (int i = 1; i <= sLen; ++i) {
			for (int j = 1; j <= tLen; ++j) {
				dp[i][j] = (S.charAt(i - 1) == T.charAt(j - 1)) ? dp[i - 1][j] + dp[i - 1][j - 1] : dp[i - 1][j];
			}
		}
		return dp[sLen][tLen];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "rabbbit", T = "rabbit";
		System.out.println(DP(S, T));
	}

}
