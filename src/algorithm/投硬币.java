package algorithm;

import java.util.Scanner;

/*
 * ������ϰ dp����ÿһ�λ��� p �ĸ��ʳɹ���1-p �ĸ���ʧ����Ͷ n �κ������� k �γɹ��ĸ���
 * ��ģ 998244353������0��k,n��105,0��p<998244353
 * ʵ���ϸ���������������ģ 998244353 �����µģ�����˵p=a/b(mod998244353)
 * ��������: ��һ���������� n,k,p
 * �������: һ��һ��������ʾ�𰸶� 998244353 ȡģ�Ľ��
 * ���� 34 21 56
 * ��� 345738771
 */
public class ͶӲ�� {
	
    static final int MAX = 100020, MOD = 998244353;
    static int n, k, p;
    static long[] inv = new long[MAX]; // ��Ԫ
    static long[] facinv = new long[MAX]; // �׳���Ԫ
    static long[] fac = new long[MAX]; // �׳�

    /*
     * �����⣬�������k~n�ĳɹ�����֮�ͼ���,�õ���Ԫ
     * ��(k~n) C(n,k)*p^k*(1-p)^(n-k)
     */
    public static void solve() {
        long sum = 0;
        getInv();
        for (int i = k; i <= n; i++) {
//            sum += C(n, i) * quickPow(p, i) % MOD * quickPow(1 - p + MOD, n - i) % MOD;
            sum += C_fac(n, i) * quickPow(p, i) % MOD * quickPow(1 - p + MOD, n - i) % MOD;
            sum %= MOD;
        }
        System.out.println(sum);
    }
    
    // C(n,k)=(n!)/((k!)*(n-k)!)%MOD
    public static long C_fac(int n, int k) {
    	return fac[n] * facinv[k] % MOD * facinv[n - k] % MOD;
    }
    
    // �����ƽ׳���Ԫ
    public static void getInv() {
    	inv[0] = facinv[0] = fac[0] = 1;
    	inv[1] = facinv[1] = fac[1] = 1;
    	for (int i = 2; i <	 MAX; i++) {
    		fac[i] = fac[i - 1] * i % MOD; // �׳� 
			inv[i] = inv[MOD % i] * (MOD - MOD / i) % MOD; // ��Ԫ
			facinv[i] = facinv[i - 1] * inv[i] % MOD; // �׳���Ԫ  
		}
    }

    /* -----------------------����������Ԫ, TLE...-----------------------------------------
     * C(n,k)=(n!)/((k!)*(n-k)!)%MOD
	 * ����: =((n~n-k)!/k!)%MOD, ����(n~n-k)!��ʾ�׳˴�n��n-k,�Ҳ�����n-k
     * => (mother % MOD * son^(MOD-2) % MOD) % MOD
     */
    public static long C(long n, long k) {
        long mother = 1, son = 1;
        for (long i = n; i > (n - k); --i) mother = (mother * i) % MOD;
        for (long i = 2; i <= k; i++) son = (son * i) % MOD;
        return ((mother % MOD) * (inv1(son, MOD) % MOD)) % MOD;
    }

	// ����������Ԫ, TLE...
    public static long inv1(long x, long mod) {
        return quickPow(x, mod - 2);
    }
    //----------------------------TLE...------------------------------------------
    
    public static long quickPow(long x, long p) {
        long ant = 1;
        while (p != 0) {
            if ((p & 1) == 1) ant = (ant * x) % MOD;
            x = (x * x) % MOD;
            p >>= 1;
        }
        return ant % MOD;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        k = input.nextInt();
        p = input.nextInt();
        solve();
        input.close();
    }

}
