package algorithm_practices;

import java.util.HashSet;
import java.util.Scanner;

/*
 * ����k��������Ϊ����y + k��y - k���ʵ��������ڸ�������[L,R],����Ҫ���������k���������ж��ٶ�
 * ����˵һ��k��������������[L,R]��,���ҽ���y+k��y-k������[L,R]��
 * ��������: һ����������L,R,k
 * �������: һ��һ�����ֱ�ʾ����[L,R]�ڵ�k���������Ķ���
 * ���룺5 10 1
 * �����2 (5, 7)(7, 9)
 * ���룺287 11633 10
 * �����4532
 * ���ݷ�Χ: 0<=L,R<=10^18, 1<=k<=10^13
 */
public class �ݳ�ԭ��_������k���ʵĸ��� {

	/*
	 * һ���������gcd(y-k, y+k)=1�����������������̫�󣬻������ơ�
	 * ����ٸ�y����L<=y<x+2k<=R,��gcd(y, y+2k)=1
	 * ����֤��: gcd(y, y+2k)=1 => gcd(y, 2k)=1
	 * �����Ϊ����ٸ�y����[L,R-2k],��gcd(y, 2k)=1
	 * ����k����̫��������Զ�2k�ֽ�������
	 * �õ�����������subNum�������ݳ�ԭ��������[L,R-2k]��2k���ʵ��������⣺����k���ʵ����ĸ�������ʱ��һ���͵ó������
	 * Hypothesis�����в�ͬ��������sign������ô������ɵ�������Ϊ: 2^(sign-1)�� ����ϣ�
	 * ��Ϊ�����ݷ�Χ��10^18�����������ᳬ��15��������ö��2^15���ǿ�ȡ��
	 * �ٸ����ӣ�k��������Ϊ2,3,5����ô2,3,5�ı�������������k���ʡ����⻹���ظ��ĵط���
	 * ��6,����2�ı�����Ҳ��3�ı�����������filter������,���ǰ�2,3,5�ı�����������һ����(����k=12)��
	 * 2: [2,4,6,8,10,12]   3: [3,6,9,12]  5: [5,10] �� ���Է������ظ��Ĳ���
	 * ���������ų�ԭ�� �в�ͬ���ʵ�p1,p2,p3����ô��������p1,p2,p3������Ϊ
	 * : S-|p1|-|p2|-|p3|+|p1��p2|+|p1��p3|+|p2��p3|-|p1��p2��p3|
	 * ����SΪ�����䣬��������������k�����ʵ�����Ҳ���Ƕ�Ӧ������p1,p2,p3����ɵı�������������S��ȥ����
	 * ������p1,p2,p3��������: |p1|+|p2|+|p3|-|p1��p2|-|p1��p3|-|p2��p3|+|p1��p2��p3|
	 * �ù���: ���ż�����ݳ�ԭ��ʵ�ֵ����ַ���: λ����״ѹ��dfs����������
	 */
	public static long solution(long l, long r, long k) {
		k <<= 1;
		r -= k;
		l = Math.max(0L, l - 1);
		// ��k�ֽ�������
		long[] subNum = phi(k);
		// [1,r]-[1,max(l-1,0)]=[l,r], ����l=0�����
		// ****************** ״ѹ **********************
//		long res = bitTolerant(subNum, r) - bitTolerant(subNum, l);
		
		// ****************** �������� ******************
//		int capacity = 1;
//		for (long m : subNum) capacity *= m;
//		long res = arrayTolerant(subNum, capacity, r) - arrayTolerant(subNum, capacity, l);
		
		// ******************** dfs ********************
//		long res = (r - dfsTolerant(subNum, 0, subNum.length, r)) - (l - dfsTolerant(subNum, 0, subNum.length, l));
	
		// dfs�Ż��棬����Ҫ���������prim���ʵĸ�����ֱ�ӿ�����������ʽ������ʵĸ���
		dfsTolerantOp(subNum, 1, 1, 0, subNum.length, l, r);
		return Math.max(0L, result);
//		return Math.max(0L, res);
	}
	
	// �ݳ�ԭ��,��[1,n]����k���ʵ����ĸ�����������λ�������״̬ѹ��(״ѹ)���
	public static long bitTolerant(long[] prim, long n) {
		int sign = prim.length;
		long res = 0;
		/* 
		 * ��ʾ���������������õ�����2(010):�õ�2����������
		 * 3(011):�õ�1,2���������� 5(101):�õ�1,3��������
		 */
		for (long i = 1; i < (1 << sign); i++) { 
			// ant��ʾ����������ϣ�2*3, 2*5��Щ�� cnt���ж���ż
			long ant = 1, cnt = 0;
			/*
			 * ����ȡ��������i�Ѿ�������Ҫȡ����������ͨ��ӳ��(i & (1 << j))�ҵ�����
			 * ��i=3(011)��(1 << j)�õ�ǰ��������index����prim=[2,3,5],��ô���ڵ�indexӳ��Ϊ:001, 010, 100
			 * ����i����&�����ж��Ƿ������i��
			 */
			for (int j = 0; j < sign; j++) {
				if ((i & (1 << j)) != 0) {
					ant *= prim[j];
					cnt++;
				}
			}
			// ���ż��
			if ((cnt & 1) == 1) {
				res += n / ant; // ��ʾ�����ʵ��������粻��������2*3���ʵ�����Ϊn/(2*3)
			} else {
				res -= n / ant;
			}
		}
		return n - res; // ���ܼ���-����prim���ʼ�����prim���ʵ�����
	}
	
	// ������dfs���
	public static long dfsTolerant(long[] prim, int index, int len, long n) {
		long res = 0;
		for (int i = index; i < len; i++) {
			// �ų��뵱ǰ����i�ظ�����
			res += n / prim[i] - dfsTolerant(prim, i + 1, len, n / prim[i]);
		}
		return res; // ���ز���prim���ʵĸ���
	}
	
	static long result;
	public static void dfsTolerantOp(long[] prim, long ant, int flag, int index, int len, long l, long r) {
		if (index >= len) {
			if (l > 0) result += flag * (r / ant - l / ant);
			else result += flag * (r / ant);
			return;
		}
		dfsTolerantOp(prim, ant, flag, index + 1, len, l, r);
		// �Ӽ��ǽ�����еģ����������prim[index],flag��Ҫ���
		dfsTolerantOp(prim, ant * prim[index], (-1) * flag, index + 1, len, l, r);
	}
	
	// �����ö�������ʵ��
	public static long arrayTolerant(long[] prim, int capacity, long n) {
		int size = prim.length;
		long[] queue = new long[capacity];
		int index = 0;
		queue[index++] = -1; // ���ż��
		for (int i = 0; i < size; i++) {
			int p = index;
			for (int j = 0; j < p; j++) {
				// queue�б��治ͬ��������ϣ������ż��
				queue[index++] = prim[i] * queue[j] * (-1);  
			}
		}
		long sum = 0;
		for (int i = 1; i < index; i++) {
			sum += n / queue[i];
		}
		return n - sum;
	}

	
	// �ֽ�������(������ŷ������)
	public static long[] phi(long k) {
		HashSet<Long> hash = new HashSet<Long>();
		for (long i = 2; i * i <= k; ++i) {
			if (k % i == 0) {
				hash.add(i);
				while (k % i == 0) k /= i;
			}
		}
		if (k > 1) hash.add(k);
		int p = 0;
		long[] res = new long[hash.size()];
		for (long i : hash) res[p++] = i;
		return res;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long L = input.nextLong(), R = input.nextLong(), k = input.nextLong();
		System.out.println(solution(L, R, k));
		input.close();
	}

}
