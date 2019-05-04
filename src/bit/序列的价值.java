package bit;

import java.util.Scanner;

/* 
 * ���һ����x�����|x|��������1�ĸ���>0�ĸ���������Ϊ����һ���õ�����
 * һ���õ����ļ�ֵ��1����һ�����õ����ļ�ֵ��-1
 * ����|2|=2(10)=10(2),|10|=|-10|=10(10)=1010(2)
 * СL��֪��һ������An�ļ�ֵ�Ƕ���
 * ��������:
 * ��һ����һ������n����ʾ����An�ĳ���
 * �ڶ�����n����������i������
 * Ai��ʾ�����е�i�����Ƕ���
 * �������: �����һ�У���ʾ������еļ�ֵ�Ƕ���
 * ʾ��1
 * 2
 * 2 1
 * 0
 * ˵��: 1(1),2(-1)
 * ʾ��2
 * 6
 * 1 2 3 4 5 6
 * 2
 * ˵��: 1(1),2(-1),3(1),4(-1),5(1),6(1)
 */

// ��Ҫ��������������������0��1�ĸ���

public class ���еļ�ֵ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		long n = input.nextInt();
		long value = 0;
		while (n-- > 0) value += judge(input.nextLong()) ? 1 : -1;
		System.out.println(value);
		input.close();
	}

	public static boolean judge(long num) {
		return (getOne(num) > getZero(num) && getOne(-num) > getZero(-num)) ? true : false;
	}

	// The number of one in positive or negative 
	public static long getOne(long number) {
		long cnt = 0;
		if (number < 0) {
			while (number != 0) {
				++cnt;
				number = (number - 1) & number; // �����ұߵ�1��Ϊ0
			}
			return cnt;
		}
		while (number != 0) {
			cnt += ((number & 1) == 1) ? 1 : 0;
			number >>= 1;
		}
		return cnt;
	}

	// The number of zero in positive or negative 
	public static long getZero(long number) {
		long cnt = 0;
		if (number < 0) {
			int i = 1;
			while (i != 0) {
				cnt += ((i & number) == 0) ? 1 : 0;
				i <<= 1;
			}
			return cnt;
		}
		while (number != 0) {
			cnt += ((number & 1) == 0) ? 1 : 0;
			number >>= 1;
		}
		return cnt;
	}

}
