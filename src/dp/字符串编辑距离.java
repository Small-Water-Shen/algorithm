package dp;

/*
 * ����Դ�ַ�����Ŀ�괮, �ܶ�Դ���������²���:
 *   * ������λ���ϲ���һ���ַ�
 *   * �滻�����ַ�
 *   * ɾ�������ַ�
 * Ҫ�󷵻���С��������, ʹ��Դ�����в��������Ŀ�괮(����С��2000)
 * */

public class �ַ����༭���� {
	
	public static int min(int i, int j, int k) {
		int t = (i < j) ? i : j;
		return (t < k) ? t : k;
	}
	
	public static int min(int i, int j) {
		return (i < j) ? i : j;
	}
	
	/* �Ƚ����ַ�������:
	 * src: algor i thm
	 * tar: alt ruisttc
	 * ��dp[i][j]��ʾԴ��src[0..i]��Ŀ�괮tar[0..j]�����ٱ༭����
	 * �߽�Ϊdp[0][j]=j, dp[i][0]=i
	 * ����: 
	 * �ȿ��ǵ�һ���ַ�, ���������һ����, ��ֻ��Ҫ����src[2..i]��tar[2..j]�Ĵ���
	 * �����һ����һ��,���Խ������²����Ӷ����һ����:
	 * 		* �޸�src�ĵ�һ���ַ�Ϊtar�ĵ�һ���ַ�,֮�����Ҫ����src[2..i]��tar[2..j]�Ĵ���
	 * 		* ɾ��src�ĵ�һ���ַ�,֮�����Ҫ����src[2..i]��tar[1..j]�Ĵ���
	 * 		* ��tar�ĵ�һ���ַ����뵽src�ĵ�һ���ַ�֮ǰ,֮�����Ҫ����src[1..i]��tar[2..j]�Ĵ���
	 * ���ɵõ�dpʽ: dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1], dp[i-1][j-1]+(src[i]==tar[j])?0:1) 
	 *                               (ɾ������)      (�������)     (�޸Ĳ���,�������Ҫ�޸�,����������+1)
	 * */
	
	// �ݹ�
	public static int dg(char[] src, char[] tar, int srcPos, int tarPos, int srcLen, int tarLen) {
		if (srcPos >= srcLen) {
			if (tarPos >= tarLen) {
				return 0;
			}
			// tar����Ĳ���ȫ���ò������
			else {
				return tarLen - tarPos;
			}
		}
		if (tarPos >= tarLen) {
			if (srcPos >= srcLen) {
				return 0;
			}
			// src���ಿ����ɾ������
			else {
				return srcLen - srcPos;
			}
		}
		// ��ǰλ���ַ����, ���±Ƚ�
		if (src[srcPos] == tar[tarPos]) {
			return dg(src, tar, srcPos + 1, tarPos + 1, srcLen, tarLen);
		} else {
			// �������
			int v1 = dg(src, tar, srcPos, tarPos + 1, srcLen, tarLen);
			// ɾ������
			int v2 = dg(src, tar, srcPos + 1, tarPos, srcLen, tarLen);
			// �޸Ĳ���
			int v3 = dg(src, tar, srcPos + 1, tarPos + 1, srcLen, tarLen);
			return min(v1, v2, v3) + 1;
		}
	}
	
	/*
	 * dp[i][j] = min(dp[i-1][j]+1, dp[i][j-1]+1, dp[i-1][j-1]+(src[i]==tar[j])?0:1)
	 *                (ɾ������)      (�������)     (�޸Ĳ���,�������Ҫ�޸�,����������+1)
	 */
	public static void DP(char[] src, char[] tar) {
		int srcLen = src.length;
		int tarLen = tar.length;
		int[][] dp = new int[srcLen + 1][tarLen + 1];
		// initialize
		for (int i = 0; i <= srcLen; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= tarLen; j++) {
			dp[0][j] = j;
		}
		// �ӵ�1���ַ���ʼ
		for (int i = 1; i <= srcLen; i++) {
			for (int j = 1; j <= tarLen; j++) {
				if (src[i - 1] == tar[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1]; 
				}
				else {
					dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1; 
				}
			}
		}
		System.out.println(dp[srcLen][tarLen]);
	}
	
	/*
	 * ����༭��������:
	 * ����Դ�ַ�����Ŀ�괮, �ܶ�Դ���������²���:
     * 		* ������λ���ϲ���һ���ַ�
     * 		* ɾ�������ַ�
     * Ҫ�󷵻���С��������, ʹ��Դ�����в��������Ŀ�괮(����С��1000)
	 * */
	public static void DP1(char[] src, char[] tar) {
		int srcLen = src.length;
		int tarLen = tar.length;
		int[][] dp = new int[srcLen + 1][tarLen + 1];
		// initialize
		for (int i = 0; i <= srcLen; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j <= tarLen; j++) {
			dp[0][j] = j;
		}
		// �ӵ�1���ַ���ʼ
		for (int i = 1; i <= srcLen; i++) {
			for (int j = 1; j <= tarLen; j++) {
				if (src[i - 1] == tar[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1]; 
				}
				else {
					dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + 1; 
				}
			}
		}
		System.out.println(dp[srcLen][tarLen]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "algorithm"; //   dinitrophenylhydrazine
		String tar = "altruisttc"; //   acetylphenylhydrazine
		DP(src.toCharArray(), tar.toCharArray());
		DP1(src.toCharArray(), tar.toCharArray());
//		System.out.println(dg(src.toCharArray(), tar.toCharArray(), 0, 0, src.length(), tar.length()));
	}
}
