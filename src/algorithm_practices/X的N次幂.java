package algorithm_practices;

/*
 * ʵ�� pow(x, n). (n��һ������)
 * ����: x = 9.88023, n = 3
 * ���: 964.498
 * ����: x = 2.1, n = 3
 * ���: 9.261
 * ����: x = 1, n = 0
 * ���: 1
 * ʱ�临�Ӷ�O(logn)
 */
public class X��N���� {

	// ʱ�临�Ӷ�O(logn)
	public static double pow(double x, int n) {
		double result = 1.0;
		// i��ż����x���ϱ���,����ͳ���result
		for (int i = n; i != 0; i /= 2) {
			if (i % 2 != 0) {
				result *= x;
			}
			x *= x;
		}
		return (n > 0) ? result : (1.0 / result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(pow(2.00000, -2147483648));
	}

}
