package algorithm;

/*
 * ����a^n % b������a��b��n����32λ�ķǸ�������
 * ���� 2^31 % 3 = 2
 * ���� 100^1000 % 1000 = 0
 * O(logn)
 */

public class Quick_involution1 {

	// �����ݣ� ���ַ�: i��ʼ��Ϊn��Ϊż������a����������result
	public static int involution(int a, int n, int b) {
		// ָ��Ϊ0
		if (n == 0) {
			return 1 % b;
		}
		// ע��Ҫ��long����Ȼ�ᳬ����Χ
		long result = 1, basis = a % b;
		for (long i = n; i > 0; i >>= 1) {
			if ((i & 1) == 1) {
				result = (result * (basis % b)) % b;
			}
			basis = (basis * basis) % b;
		}
		return (int) (result % b);
	}
	
	public static void main(String[] args) {
		int a = 11, n = 12345, b = 123898;
		System.out.println(involution(a, n, b));
	}
}
