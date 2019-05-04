package bit;

public class λ����Ӽ��˳� {
	
	static final int MAX = Integer.MAX_VALUE;
	static final int MIN = Integer.MIN_VALUE;

	/* ��λ����ʵ�ּӷ�
	 * �����ļӷ���2+1=3 => 10&01=11
	 * �۲��֪�� ��û�н�λ������£��ӷ���ʵ���ǽ���^����
	 * �жϽ�λ������� 3+2=5 => 11+10=100
	 * ��&���ж��Ƿ���Ҫ��λ�� 
	 * 1 & 1 = 1 (��λ) 		1 ^ 1 = 0 (��Ӧ�ļӷ�)
	 * 1 & 0 = 0	 		1 ^ 0 = 1
	 * 0 & 1 = 0			0 ^ 1 = 1
	 * 0 & 0 = 0			0 ^ 0 = 0
	 * ��λ����: (1&1)<<1
	 * �磺 3+2=5 
	 *  => 11 ^ 10 = 01 (�Ƚ��мӷ�)
	 *  => (11 & 10) << 1 = 100 (��λ)
	 *  ��ʱֻ��Ҫ��01+100=101���ɵõ��𰸣�������ʹ��+�������ٽ���һ����������
	 *  => 01 ^ 100 = 101 (�Ƚ��мӷ�)
	 *  => (01 & 100) << 1 = 100 (��λ��Ч��������Ҫ��λ) => 101
	 */
	public static int add(int a, int b) {
		int addOp = a ^ b;  // �ӷ�����
		int bitOp = a & b;  // �ж��Ƿ��λ
		// ����Ҫ��λ����ֹ
		while (bitOp != 0) {
			int addOpTmp = addOp;  // ��¼��һ�μӷ���ֵ
			int addBit = bitOp << 1;  // ��λ��õ���ֵ�����������
			addOp ^= addBit;  // �ٴν���^���ӷ���
			bitOp = addBit & addOpTmp;  // �ٴ��ж��Ƿ���Ҫ
		}
		return addOp;
	}
	
	// a-b=a+(-b) ���� => �ӷ�
	public static int sub(int a, int b) {
		// ȡ�����Ķ�����(ȡ����ĩβ+1)
		b = add(~b, 1);
		// ���мӷ�����(��д��)
		int c;
		while (b != 0) {
			c = (a & b) << 1; // �ж��Ƿ��λ 
			a ^= b; // �Ӳ���
			b = c;
		}
		return a;
	}
	
	/* �˷��ж��ֽⷨ������ͨ�ľ���ת��Ϊ�ӷ�����: 6*3 => 6+6+6 O(n)
	 * ��Ϊ����һλ���ǳ���2��������λ�Ʋ������۲�6(110)*10(1010)
	 * ���ǽ�10���������:1000��0010, �Ա�������Ʋ���
	 * ����110*1010 => 110*1000+110*0010 => 110<<3+110<<1 (����) O(nlogn)
	 */
	public static int mul(int a, int b) {
		boolean aNeg = (a < 0) ? true : false, bNeg = (b < 0) ? true : false;
		a = aNeg ? -a : a;
		b = bNeg ? -b : b;
		int res = 0, bit = 0;
		while (b != 0) {
			if ((b & 1) == 1) res = add(res, a<<bit);
			b >>= 1;
			++bit;
		}
		return (aNeg && bNeg || !aNeg && !bNeg) ? res : -res;
	}
	
	/*
	 * �����ж��ֽⷨ������ͨ�ľ���ת��Ϊ��������: �ӱ������ϼ�ȥ���������ܼ����ٴ�֮���ò�����
	 * 6/3 => 6-3-3 �� ֻ�������γ��������Ϊ2�� O(n)
	 * ����һ��Ҳ�Ǻͳ˷���ͬС�죬���ó�������ֱ�����ڱ�����֮ǰ�õ�һ�����Ļ�n��ֵ��˵�������������ٰ���2^n��������
	 * Ȼ���ȥ����������������ҵ�n-1������1��ֵ�������еĻ�����Ӽ��ɵõ����, ע�⴦��߽�
	 */
	public static int div(int a, int b) {
		if (a == 0) return 0;
		if (b == 0) return (a >= 0) ? MAX : MIN;
		if (b == MIN && b == -1) return MAX;
		boolean resNeg = (a > 0 && b < 0 || a < 0 && b > 0);
		long A = Math.abs((long) a);
		long B = Math.abs((long) b);
		int res = 0;
		while (A >= B) {
			int bit = 0;
			while (A >= (B << bit)) ++bit;
			A -= (B << (bit - 1));
			res += (1 << (bit - 1));
		}
		return resNeg ? -res : res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(-5, 1));
		System.out.println(sub(5, 1));
		System.out.println(mul(-6, -10));
		System.out.println(div(-2147483648, -1));
	}

}
