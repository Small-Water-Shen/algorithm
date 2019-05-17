package algorithm;

/*
 * ���һ���㷨���ҳ�ֻ��������2��3��5 �ĵ� n С������
 * �������������磺1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 */

public class ����2 {

	// ������ȥ����
	public static int nthUglyNumber(int num) {
		// write your code here
		// storage ugly number
		int[] ugly = new int[num];
		ugly[0] = 1;
		int count = 1;
		int n2 = 0, n3 = 0, n5 = 0;
		while (count < num) {
			ugly[count] = min(ugly[n2] * 2, ugly[n3] * 3, ugly[n5] * 5);
			// update
			if (ugly[count] / ugly[n2] == 2) n2++;
			if (ugly[count] / ugly[n3] == 3) n3++;
			if (ugly[count] / ugly[n5] == 5) n5++;
			count++;
		}
		return ugly[count - 1];
	}
	
	public static int min(int a, int b, int c) {
		int m = (a < b) ? a : b;
		return (m < c) ? m : c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthUglyNumber(1));
	}

}
