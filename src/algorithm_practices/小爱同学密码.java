package algorithm_practices;

/*
 * С��ͬѧ��һ�������������������о�λ���֣�С��ͬѧÿ�λ��A,B,C,D,mod,n������������ 
 * ��Ŀ�������ģ�f(1)=A, f(2)=B, f(n)=f(n-1)*f(n-2)*(c^d), n>2
 * ����С��ͬѧ������G(n)��ֵ��G(n)ΪF(n)��ǰn����������ø�ֵ��Ϊ�����������롣
 * ���ڽ���������Դ� G(n)%mod
 * �������ݡ�ÿ����� 6 ���������ֱ���� A, B, C, D, mod, n. (1<=A,B,C,D,mod,n<=1000000000)���������������� 2000.
 * ��� G(n)%mod ��ֵ��
 * �𰸱��� 9 λ��Ч���֣������� 0.
 * input:
 * 2 2 2 2 1000 3
 * 7 9 3 4 6 5
 * output:
 * 000000064
 * 000000003
 */
public class С��ͬѧ���� {

    /*
    * f(1)=A, f(2)=B
    * f(3)=f(1)*f(2)*C^D => A*B*C^D
    * f(4)=f(2)*f(3)*C^D => A*B^2*(C^D)^2
    * f(5)=f(3)*f(4)*C^D => A^2*B^3*(C^D)^4
    * major: find the value of index of A, B, C^D
    *  A : 1 0 1 1 2 3
    *  B : 0 1 1 2 3 5
    * C^D: 0 0 1 2 4 7
    *  N : 1 2 3 4 5 6 ...
    * ��ӦG(n)��G(n)ΪF(n)��ǰn�����
    *  A : 1 1 2 3 5 8
    *  B : 0 1 2 4 7 12
    * C^D: 0 0 1 3 7 14
    *  N : 1 2 3 4 5 6 ...
    * �ù��ɣ�
    * B��n���ָ��ΪA��f(n+1)-1��C^D��n��ָ��ΪA+B-N
    * */
	
	// �����ݾ���
	public static class matrix {
		long[][] m = new long[2][2];
		public matrix() { }
		public matrix(long a, long b, long c, long d) {
			this.m[0][0] = a;
			this.m[0][1] = b;
			this.m[1][0] = c;
			this.m[1][1] = d;
		}
		@Override
		public String toString() {
			return "[[" + m[0][0] + " " + m[0][1] + "],\n ["
					+ m[1][0] + " " + m[1][1] + "]]";
		}
		
	}
	
	/*
	 * ŷ�������� phi(x)=x(1-1/p1)*(1-1/p2)*...(1-1/pn)
	 * ����p1, p2����pnΪx����������������p1..pn��x�ֽ��������
	 * �磺phi(8)=8*(1-1/2)=4��phi(12)=12*(1-1/2)*(1-1/3)=4
	 * ����ָ����ը��Ҫ���ݡ�
	 * ŷ�����ݣ�(a^b)%c => (a^(b%phi(c)+phi(c)))%c
	 */
	public static long phi(long n) {
		long res = n, i = 2;
		for (; i * i <= n; i++) {
			if (n % i == 0) {
				// x(1-1/p)=x-x/p
				res = res - res / i;
				// �ų�i�ı���
				while (n % i == 0) n /= i; 
			}
		}
		// ʣ���n����
		if (n > 1) res = res - res / n;
		return res;
	}

	/*
	 * �����������쳲���������
	 * ���ھ���˷������ʽ֮��Ĺ�ϵ��
	 * f(n)=f(n-1)+f(n-2) => f(n)=1*f(n-1)+1*f(n-2)
	 * f(n-1)=f(n-1) => f(n-1)=1*f(n-1)+0*f(n-2)
	 * ��Ϊ����
	 * | f(n) |   |1  1|   |f(n-1)|
	 * |      | = |    | * |      |
	 * |f(n-1)|   |1  0|   |f(n-2)|
	 * ��һ����
	 * | f(n) |   |1  1|^(n-1)     |f(2)|
	 * |      | = |    |       *   |    |
	 * |f(n-1)|   |1  0|           |f(1)|
	 */
	// һ�ξ���ĳ˷�
    public static matrix multiply(matrix a, matrix b, long mmod) {
        matrix c = new matrix(0, 0, 0, 0);
        for (int i = 0; i < a.m.length; i++) {
			for (int j = 0; j < b.m[0].length; j++) {
				for (int k = 0; k < b.m.length; k++) {
					c.m[i][j] += (a.m[i][k] * b.m[k][j]) % mmod;  
					c.m[i][j] %= mmod; 
				}
			}
		}
        return c;
    }
    
    // ���������, ��쳲���������
    public static matrix quickMul(matrix coe, long n, long mmod) {
    	matrix res = new matrix(1, 0, 0, 1); // ��λ����
    	while (n != 0) {
    		// �������Ͻ��,ż��������
			if ((n & 1) == 1) res = multiply(coe, res, mmod);
			coe = multiply(coe, coe, mmod);
			n >>= 1;
		}
    	/* resΪ:
    	 * |1  1|^(n-1)        |3 2|         |5 3|
	     * |    |      => n=3: |   | => n=4: |   |
	     * |1  0|              |2 1|         |3 2|
	     * res.m[0][1]=res.m[1][0]��쳲�������n��
	     * res.m[0][0]��쳲�������n+1��
    	 */
    	return res;
    }

    // ���Ŀ����ݣ���a^n
    public static long quickPow(long a, long n, long mod) {
    	long res = 1;
    	a %= mod;
    	while (n != 0) {
			if ((n & 1) == 1) res = (res * a) % mod;
			a = (a * a) % mod;
			n >>= 1;
		}
    	return res % mod;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int A = 7, B = 9, C = 3, D = 4, mod = 6, N = 5;
        long mmod = phi(mod); // ŷ������
//        System.out.println(mmod);
        matrix coe = new matrix(1, 1, 1, 0); // ��ʼ����
        matrix matrixA = quickMul(coe, N, mmod); // a��ָ���ľ���
//        matrix matrixB = quickMul(coe, N + 1, mmod); // b��ָ���ľ���
//        System.out.println(matrixA.toString() + "\n" + matrixB.toString());
        long indexA = matrixA.m[0][1] + mmod; // a��ָ��
        long indexB = matrixA.m[0][0] - 1 + mmod; // b��ָ��
        long indexCD = indexA + indexB - N % mmod + mmod;
        long CD = quickPow(C, D % mmod + mmod, mod); // ��C^D��ֵ
        long result = (((quickPow(A, indexA, mod) * quickPow(B, indexB, mod)) % mod)
        		* quickPow(CD, indexCD, mod)) % mod;
//        System.out.println(result);
        String res = "";
        for (int i = 1; i <= 9 - String.valueOf(result).length() ; i++) {
			res += "0";
		}
        System.out.println(res + result);
	}

}
