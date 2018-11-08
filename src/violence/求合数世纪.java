package violence;

import java.util.Scanner;

/*
 *  20���͵�100����ţ�1901-2000������13��������
 *  ��21���͵�100����ţ�2001-2100������14��������
 *  ��ô���Ƿ����һ�����͵�100�������һ��������û�У�
 *  ����һ�����͵�100������в�����һ��������
 *  ��100�����ȫΪ���������ͳ�Ϊ�������͡�����Ƴ���̽������n���������ͣ�n<10����
 *  
 *  Sample Input
 *  1
	Sample Output
	16719����:1671801-1671900
 * */

public class ��������� {

	static int count = 0;

	public static boolean check(int number) {
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean func(int start, int end) {
		for (int i = start; i <= end; i++) {
			if (check(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for (int i = 0; i <= Integer.MAX_VALUE; i++) {
			int start = 100 * i + 1;
			int end = start + 99;
			if (func(start, end)) {
				count++;
				if (count == n) {
					System.out.println((i + 1) + "����:" + start + "-" + end);
					System.exit(0);
				}
			}
		}
		input.close();
	}

}
