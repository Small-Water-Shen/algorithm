package algorithm_practices;

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
public class �����ݼ������ѧ {

	static final long MOD = 1000000007L;

	/*
	 * C(n,m)=(m!)/((m-n)!*n!)
	 * A(n,m)=(m!)/(m-n)!
	 * C(n-3,23)*A(n,n)
	 */
	public static long cowCounter(long n) {
		long child = pow(23, MOD);
		long mother = (pow(23 - n + 3, MOD) * pow(n - 3, MOD)) % MOD;
		long c = child / mother;
		long a = pow(n, MOD);
		return (a * c) % MOD;
	}
	
	public static long pow(long n, long mod) {
		long res = 1;
		while (n > 1) res = (res * n--) % mod;
		return res;
	}
	
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
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n = input.nextInt();
		long sum = quickMul(26, n, MOD);
		long cow = cowCounter(n);
		System.out.println(sum);
		System.out.println(cow);
		System.out.println(sum - cow);
		input.close();
	}


}
