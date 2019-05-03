package ״ѹdp;

import java.util.Scanner;

/*
 * �Դ��ϴ�Сw����ţ����֮�󣬾�һֱ�Դ˹����ڻ���
 * ����"cow"��Ϊ��Сw�Ľ��ɣ������ú�"cow"�����"owc"������ͬʱ����"c","w","o"�Ķ����������Ľ���������
 * СG�������һ������Ϊn���ַ��ĳ�ʫ���������´������Ľ��ɡ�����������Ҫ��ʫ�г��������Ľ��ɾ����ɲ��ͣ�����...��һд��ʫ��������һ�С�
 * СG��֪�����ж����ֵ�ʫ���ܲ��������Ľ���
 * ע��СGֻ����Сд��ĸдʫ
 * ��������: һ��һ������n��ʾʫ�ĳ���
 * �������: һ��һ��������ʾСG�ж����ֿ��ܵ�ʫ������СW�Ľ��ɣ����ڿ�����Ҳ��������109+7ȡĤ�����
 * ����: 3
 * ���: 17570
 * ˵��: n=3�Ұ���"c","o","w"��ֻ��6���������Դ���26^3-6=17570
 */
public class ���ɵ�ʫ {

	static final long MOD = 1000000007L;
	
	// ������������
	public static long quickMul(long a, long n, long mod) {
		long res = 1;
		while (n != 0) {
			if ((n & 1) == 1) res = (res * a) % mod;
			a  = (a * a) % mod;
			n >>= 1;
		}
		return res;
	}
	
	/* ״ѹdp
	 * dp[i][state],state��[0,7]��ʾǰi���ַ���c��o��w�Ƿ���ֹ�, ��ö���ַ�ת��
	 * ���ͳ�ƴ𰸵�ʱ�����ö��״̬ͳ�ƣ�Ҳ�����ܷ�����-���Ϸ�������
	 */
	public static long dp1(int n, long mod) {
		long[][] dp = new long[n + 1][1<<3];
		dp[0][0] = 1; 
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < 26; j++) {
				for (int k = 0; k < 8; k++) {
					// ѡ�����c,o,w�е�ĳ�����ַ������
					if (j < 3) dp[i][k|(1<<j)] = (dp[i][k|(1<<j)] + dp[i - 1][k]) % mod;
					else dp[i][k] = (dp[i][k] + dp[i - 1][k]) % mod;  
				}
			}
		}
		return (quickMul(26, n, MOD) - dp[n][7] + MOD) % MOD;
	}
	
	/* ��ͨdp
	 * dp[i][state],state��[0,7]��ʾǰi���ַ���c��o��w�Ƿ���ֹ�
	 * dp[i][0]��ʾǰi���ַ�û��c,o,w�ĸ���
	 * dp[i][1]��ʾǰi���ַ���c,û��o,w�ĸ���
	 * dp[i][2]��ʾǰi���ַ���o,û��c,w�ĸ���
	 * dp[i][3]��ʾǰi���ַ���w,û��c,o�ĸ���
	 * dp[i][4]��ʾǰi���ַ���c,o,û��w�ĸ���
	 * dp[i][5]��ʾǰi���ַ���c,w,û��o�ĸ���
	 * dp[i][6]��ʾǰi���ַ���o,w,û��c�ĸ���
	 */
	public static long dp2(int n, long mod) {
		long[][] dp = new long[n + 1][1<<3];
		dp[1][0] = 23;
		dp[1][1] = dp[1][2] = dp[1][3] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] * 23) % mod; // û��c,o,w�ĸ���
			dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] * 24) % mod; // ��c,û��o,w�ĸ���
			dp[i][2] = (dp[i - 1][0] + dp[i - 1][2] * 24) % mod; // ��o,û��c,w�ĸ���
			dp[i][3] = (dp[i - 1][0] + dp[i - 1][3] * 24) % mod; // ��w,û��c,o�ĸ���
			dp[i][4] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][4] * 25) % mod; // ��c,o,û��w�ĸ���
			dp[i][5] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5] * 25) % mod; // ��c,w,û��o�ĸ���
			dp[i][6] = (dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][6] * 25) % mod; // ��o,w,û��c�ĸ���
		}
		long ant = 0;
		for (int i = 0; i <= 6; i++) ant = (ant + dp[n][i]) % mod;
		return ant;
	}

	/* �ݳ�ԭ�� (Efficient)
	 * ����c,o,w�ĸ���=C(3,0)*��0���Ƿ��ַ��ķ�����-C(3,1)*��1���Ƿ��ַ��ķ�����+C(3,2)*����2���Ƿ��ַ��ķ�����
	 * Formula = C(3,0)*pow(23,n) - C(3,1)*pow(24,n) + C(3,2)*pow(25,n)
	 */
	public static long tolerant(int n, long mod) {
		long ant = quickMul(23, n, mod) - 3 * quickMul(24, n, mod) + 3 * quickMul(25, n, mod);
		ant = ((ant % mod) + mod) % mod;
		return ant;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(dp1(n, MOD));
		System.out.println(dp2(n, MOD));
		System.out.println(tolerant(n, MOD));
		input.close();
	}

}
