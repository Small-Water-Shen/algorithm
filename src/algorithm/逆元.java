package algorithm;

/*
 * (a/b)%m ʱ����b���ܻ���󣬻���ֱ����ȵ����������������Ϊ�˷�
 * ��c��b����Ԫ������b*c��1(mod m)
 * ��(a/b)%m = (a/b)*1%m = (a/b)*b*c%m = a*c(mod m)
 * ��a/b��ģ����a*b����Ԫ��ģ��
 */
public class ��Ԫ {
	
	/*
     * ����С��������Ԫ��O(nlogn)�ĸ��Ӷȣ��Ҿ����Դ�mҪ������������n�ﵽ1e7�ᱬը
     * ���ݷ���С�������ǿɵó���m������ʱ��������a������a^(m)�� a(mod m),����a,m����
     * �Ƶ�һ�£�a^(m)��a(mod m) => a^(m)-a��0(mod m) => a(a^(m-1)-1)��0(mod m)
     * => a^(m-1)-1��0(mod m) => a^(m-1)��1(mod m)
     * ����Ϊc��a����Ԫ����a*c��1(mod m)��������ʽ�� a*c=a^(m-1)(mod m)
     * => c=a^(m-2)(mod m) c����a����ģm����Ԫ
	 * ��Ϊc��b����ģm����Ԫ����(a/b)%m => (a*c)%m �� c=b^(m-2)(mod m)������
	 * (a*b^(m-2))(mod m)
	 */
    public static long inv1(long x, long mod) {
        return quickPow(x, mod - 2, mod);
    }

    public static long quickPow(long x, long p, long mod) {
        long ant = 1;
        while (p != 0) {
            if ((p & 1) == 1) ant = (ant * x) % mod;
            x = (x * x) % mod;
            p >>= 1;
        }
        return ant % mod;
    }
    
    /*
     * ��չŷ������㷨(��ŷ)����Ԫ
     * ��ŷ��ʽ����: ax+by = (a,b)��(a,b)����gcd(a,b), a��b����֪��,x��y��һ���
     * ��ô�����׿���֪��, ��a��b���ʵ������,ԭ���ĵ�ʽ�ͱ����: ax+by = 1 
     * ��������Ԫ��ʽ��: a*inv(a)=1(mod m), ��x=inv(a), y=m,
     * ��ôͬ���ʽ�Ӿͱ�Ϊ: a*x=1(mod y),Ȼ��b�����: a*x+b*y=1 
     * ����y�ǲ�ȷ����,�������������Ҫ��x����y��������ûʲôӰ��,so��ʽ������x����a����Ԫ
     * ax+by=(a,b)=1����շת����������(b,a%b)=bX+(a%b)Y=1
     * ���н�a%b����Ϊ: a-b*(a/b), ��(b,a-b*(a/b))=bX+(a-b*(a/b))Y=1
     * => bX+aY-b*(a/b)*Y => 
     */
    
    /*
     * ��������Ԫ, ��1~n����Ԫ(����)
     * ��i��[1,n], s=m/i, t=m%i, ����: s * i + t = m
     * => s * i + t = 0 (mod m)
     * => t = -s*i (mod m) ����
     * => t/(t*i) = -s*i/(t*i) (mod m) ����ͬʱ����(t*i)
     * => 1/i = -s/t (mod m)
     * => inv(i) = -s * inv(t) (mod m) ת��Ϊ��Ԫ
     * => inv(i) = -(m/i) * inv(m%i) (mod m) ����s=m/i,t=m%i
     * ���ù�ʽ: inv(i) = inv(m%i) * -(m/i) (mod m)
     */
    public static long[] getInv(int n, int mod) {
    	long[] inv = new long[n + 1];
    	inv[0] = inv[1] = 1;
    	for (int i = 2; i <= n; i++) {
			inv[i] = inv[mod % i] * (mod - mod / i) % mod; 
		}
    	return inv;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
		// ��(a/b)%m => (a*b^(m-2))(mod m)
        long a = 21, b = 34, mod = 998244353, ant;
		b = inv1(b, mod);
		ant = ((a % mod) * (b % mod)) % mod;
        System.out.println(ant);
    }

}
