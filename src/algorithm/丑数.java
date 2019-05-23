package algorithm;

/*
 * дһ�����������һ�������ǲ��ǳ�����
 * �����Ķ����ǣ�ֻ���������� 2, 3, 5 ����������
 * ���� 6, 8 ���ǳ��������� 14 ���ǳ�����Ϊ�������������� 7��
 * ���ǿ�����Ϊ 1 Ҳ��һ��������
 * */
public class ���� {

	public static boolean isUgly(int num) {
		// write your code here
		if (num == 0) {
			return false;
		}
		if (num == 1) {
			return true;
		}
		while (num % 2 == 0) num /= 2;
		while (num % 3 == 0) num /= 3;
		while (num % 5 == 0) num /= 5;
		return (num == 1) ? true : false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(0));
	}

}
