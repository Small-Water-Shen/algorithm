package algorithm;

import java.util.*;

/**

 */
public class ��ӡʮ��ͼ {

	// �ȴ�ӡ��1/4 �ٸ������¶Գƺ����ҶԳƴ�ӡȫ��
	public static boolean judge(int i, int j, int n) {
		// �н���
		int temp = (5 + n * 4) / 2 + 1;
		// ���¶Գ�
		if (i > temp) {
			i = temp - (i - temp);
		}
		// ���ҶԳ�
		if (j > temp) {
			j = temp - (j - temp);
		}
		// ���Ͻǵ�����.
		if (i <= 2 && j <= 2) {
			return false;
		}
		// ��i>2ʱ����������3������$
		if (i % 2 != 0 && j >= i - 2) {
			return true;
		}
		// ��j>2ʱ����������һ��$���ų�j!=i-1�����
		if (j % 2 != 0 && j != i - 1) {
			return true;
		}
		// ������Ϊ'.'���൱����ȫ��'.'�Ļ����ϻ�ͼ
		return false;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		// ��ӡ
		for (int i = 1; i <= (5 + n * 4); i++) {
			for (int j = 1; j <= (5 + n * 4); j++) {
				if (judge(i, j, n)) {
					System.out.print('$');
				} else {
					System.out.print('.');
				}
			}
			System.out.println();
		}
		input.close();
	}
}
