package dp;

/*
 * ����һ���ַ���s����s�ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��ġ�
 * ����s����Ҫ��ĵ����ٷָ������
 */
public class �ָ���Ĵ�2 {

	/*
	 * dp[i]��ʾǰi���Ӵ��Ƿ��ǻ��Ĵ�����ʼdp[i]=MAX
	 * dp[i] = min(dp[j]+1, dp[i]); (j = i - 1)
	 */
    public static int minCut(String s) {
        // write your code here
    	int len = s.length();
    	if (s == null || len == 0) {
			return 0;
		}
    	int[] dp = new int[len];
		// ���ж�ǰi���Ƿ��ǻ��ģ��Ǿ�Ϊ0
    	for (int i = 0; i < len; i++) {
    		if (isPerm(s, 0, i)) {
				dp[i] = 0;
				continue;
			}
			dp[i] = Integer.MAX_VALUE; 
    		// �ж�i~0���Ƿ����
    		for (int j = i - 1; j >= 0; j--) {
    			if (isPerm(s, j + 1, i)) {
					dp[i] = (dp[i] < dp[j] + 1) ? dp[i] : dp[j] + 1; 
				}
			}
		}
    	return dp[len - 1];
    }
    
    public static boolean isPerm(String str, int front, int back) {
    	while (front < back) {
			if (str.charAt(front) != str.charAt(back)) {
				return false;
			}
			front++;
			back--;
		}
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut("abbaac"));
	}

}
