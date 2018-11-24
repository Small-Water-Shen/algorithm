package dp;

import java.util.Arrays;
import java.util.Scanner;

/*
 * ����һ�����϶��־�������⣺�ø����ļ���Ǯ�Ҵճ�ĳ��Ǯ����һ������ж��ַ�ʽ��
 * ���磺������6��Ǯ����ֵΪ2��5��10��20��50��100��������15Ԫ��������5��2��1��5����3��5��
 * �ֻ���1��5��1��10���ȵȡ���Ȼ��������Ҫ2��Ǯ�ң���1��5��1��10�����ܴճ�15Ԫ��
 * ���������ǣ����������ɸ�������ͬ��Ǯ����ֵ��
 * �����������Ҫ���ٸ�Ǯ�Ҳ��ܴճ�ĳ��������Ǯ�����������Ǯ����ֵ��
 * �����ܴճ��������impossible!����
 * 
 *  Input
	��һ��������һ��������T��������T��������ݣ��ڶ����������ǵ�һ��������ݣ�
	���У��ڶ����Ǹ�����Ǯ���������е�1��������n����Ǯ����ֵ������������n������������ÿ����ֵ�����������ġ��������ǵڶ����������...�Դ����ơ�
	Ouput
	�����������Ҫ��Ǯ���ܸ��������ŷֱ����ÿ��Ǯ�ҵ���ֵ x ������� y����ʽΪ x(y)
	Sample Input
	3
	15
	4 2 5 10 20
	21
	3 5 10 20
	36
	5 2 5 10 20 50
	Sample Output
	2 10(1) 5(1)
	impossible!
	5 20(1) 10(1) 2(3)
 * */

public class ����Ǯ���� {

	/*
	 * �оֲ��⣬ ���磺��17�� ��1 3 8 10��ֵ
	 * */
	public static int[] greedy(int[] money, int value) {
		Arrays.sort(money);
		int len = money.length;
		// �±������ֵ�� ֵ������Ŀ.
		// 0λ��������
		int[] result = new int[money[len - 1] + 1];
		boolean flag = false;
		for (int i = len - 1; i >= 0; i--) {
			if (money[i] > value)
				continue;
			if (value % money[i] == 0) {
				flag = true;
			}
			result[money[i]] = value / money[i];
			result[0] += value / money[i];
			value %= money[i];
			if (flag)
				break;
		}
		if (value != 0) {
			result[0] = -1;
		}
		return result;
	}
	
	// �ݹ�
	public static int dg() {
		
		return 0;
		
	}
	
	// ����dp
	public static void dp() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int value = input.nextInt();
		int n = input.nextInt();
		int[] money = new int[n];
		for (int i = 0; i < n; i++) {
			money[i] = input.nextInt();
		}
		int[] count = greedy(money, value);
		if (count[0] == -1) {
			System.out.println("impossible!");
		} else {
			System.out.print(count[0] + " ");
			for (int i = 1; i < count.length; i++) {
				if (count[i] != 0) {
					System.out.print(i + "(" + count[i] + ") ");
				}
			}
		}
		input.close();
	}
}
