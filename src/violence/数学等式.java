package violence;

/*
 * ���е�ʽ�� a*x1^3 + b*x2^3 + c*x3^3 = d*x4^3 + e*x5^3
 * ����-50 <= a,b,c,d,e,x <= 50, �Ҷ���Ϊ0
 * ����a,b,c,d,e����������ʽ������x1,x2,x3,x4,x5����Ϊ�������ĸ���
 */
public class ��ѧ��ʽ {
	
	public static void initialize(short[] hash) {
		for (int i = 0; i < hash.length; i++) {
			hash[i] = 0; 
		}
	}
	
	/*
	 * 5��ѭ����������
	 * ����ʽ������ߣ�ʱ�临�ӽ�ΪO(n^3), �ù�ϵ���¼
	 */
	public static void main(String[] args) {
		int a = -14, b = -42, c = -23, d = 27, e = -48;
		// ȡMAX���ĸ�����˵����ֵ
		int MAX = 4 * 50 * 50 * 50 * 50, sum, count = 0;
		short[] hash = new short[MAX];
		initialize(hash);
		// the left of equation
		for (int i = -50; i <= 50; i++) {
			if (i == 0) continue;
			for (int j = -50; j <= 50; j++) {
				if (j == 0) continue;
				for (int k = -50; k <= 50; k++) {
					if (k == 0) continue;
					sum = a * i * i * i + b * j * j * j + c * k * k * k;
					if (sum < 0) sum += MAX; // �����������					
					hash[sum]++; // �����ߵ�ʽ�Ľ��(index is result)
				}
			}
		}
		// the right of equation
		for (int n = -50; n <= 50; n++) {
			if (n == 0) continue;
			for (int m = -50; m <= 50; m++) {
				if (m == 0) continue;
				sum = d * n * n * n + e * m * m * m;
				if (sum < 0) sum += MAX;
				// ��ʽ���������hash�У����������
				if (hash[sum] > 0) count += hash[sum];
			}
		}
		System.out.println(count);
	}

}
