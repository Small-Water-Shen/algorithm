package algorithm_practices;

/*
 * ʵ�� int sqrt(int x) ���������㲢���� x ��ƽ������
 * ����:  0
 * ���: 0
 * ����: 3
 * ���: 1
 * �������ͣ�
 * ���ض�x�����ź�����ȡ���Ľ����
 * ����: 4
 * ���: 2
 * Challenge
 * O(log(x))
 */

public class X��ƽ���� {

	// binary search
	public static int sqrt(int x) {
		// x/2 : optimize efficiency
		long i = 0, j = (x < 2) ? x : x >> 1;
		while (i <= j) {
			// half of i and j
			long mid = (j - i) / 2 + i;
			if ((mid * mid) < x) {
				i = mid + 1;
			} else if ((mid * mid > x)) {
				j = mid - 1;
			} else {
				break;
			}
		}
		return (int) j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(1)); // 2147483647
	}

}
