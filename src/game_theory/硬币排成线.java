package game_theory;

import java.util.Scanner;

/*
 * �� n ��Ӳ���ų�һ���ߡ������������������ұ��������� 1 �� 2 ��Ӳ�ң�ֱ��û��Ӳ��Ϊֹ���õ����һöӲ�ҵ��˻�ʤ��
 * ���ж� ������� ��ʤ���Ǳذ�? (���������߶��㹻����)
 * ����ʤ, ���� true, ���򷵻� false.
 * ����: 1
 * ���: true
 * ����: 4
 * ���: true
 * ����: 
 * ������ҵ�һ������һ��Ӳ��, ��ʱ��ʣ����.
 * ��ʱ���ۺ��������һ����������, ��һ��������Ҷ����԰�ʣ�µ�Ӳ������.
 * O(1) ʱ�临�Ӷ���O(1) �洢��
 */
public class Ӳ���ų��� {
	
	public static boolean game(int n) {
		return n % 3 != 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(game(n));
		input.close();
	}

}
