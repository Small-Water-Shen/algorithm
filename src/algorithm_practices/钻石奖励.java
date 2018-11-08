package algorithm_practices;

import java.util.Scanner;

/*
 * �����Ǿ����á�Ͷ������ķ�ʽ���������һ���ж��й��������ˡ�
 * ���ǽ�1��������ʯ���гɾ���ͨ��Ͷ��Բ��������������ʯ������
 * ����ÿ����ʯ��x��y���궼��1��99�����������������������Բ��λ�ã�
 * ����������ж�һ��������ܻ�ö��ٿ�������ʯ��
	Input
	�������ݷ����У���һ���Ǿ�����������������ڶ�������Բ�ĵ�����x,y���뾶r
	Ouput
	���Բ���ڣ�����Բ�����ϣ�����ʯ��������
	Sample Input
	4 5
	2.5 2 1.5
	Sample Output
	8
 * */

public class ��ʯ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		double x = input.nextDouble();
		double y = input.nextDouble();
		double r = input.nextDouble();
		int count = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				double distance = Math.sqrt(Math.pow(Math.abs(i - x), 2) + Math.pow(Math.abs(j - y), 2));
				// ��Բ��
				if (distance <= r) {
					count++;
				}
			}
		}
		System.out.println(count);
		input.close();
	}

}
