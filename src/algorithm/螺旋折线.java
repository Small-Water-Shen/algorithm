package algorithm;

import java.util.Scanner;

/**
 * @author ��Сˮ
 * 
 * tip��ת��Ϊͬ�������Σ�Ȼ����������ľ���
 *
 */
public class �������� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			long x = input.nextInt();
			long y = input.nextInt();
			long dis = 0;
			long max = (Math.abs(x) >= Math.abs(y)) ? Math.abs(x) : Math.abs(y);
			long radix = 8 * (1 + max - 1) * (max - 1) / 2;
			// ������
			// ��������
			if (x <= 0 && y <= 0) {
				if (x == y) {
					dis = 8 * (1 + max) * max / 2;
				}
				if (x < y) {
					dis = radix + (max - Math.abs(y));
				}
				if (x > y) {
					dis = 8 * (1 + max) * max / 2;
					dis -= (max - Math.abs(x));
				}
			}
			// �ڶ�����
			if (x <= 0 && y >= 0) {
				dis = radix + max + y + (max - Math.abs(x));
			}
			// ��һ����
			if (x >= 0 && y >= 0) {
				dis = radix + max * 3 + x + (max - y);
			}
			// ��������
			if (x >= 0 && y <= 0) {
				dis = radix + max * 5 + Math.abs(y) + (max - x);
			}
			System.out.println(dis);
		}
		input.close();
	}

}
