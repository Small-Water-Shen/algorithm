package dp;

import java.util.Scanner;

/**
 * ����K������������{ N1, N2, ..., NK }�����������������пɱ�ʾΪ{ Ni, Ni+1, ..., Nj }��
 * 
 * ���� 1 <= i <= j <= K�������������������������������Ԫ�غ�����һ����
 * 
 * �����������{ -2, 11, -4, 13, -5, -2 }�����������������Ϊ{ 11, -4, 13 }������Ϊ20��
 *
 */
public class �������������֮�� {

	static int[] data;

	// 2��forѭ������ɨ��
	public static void Violence() {
		int maxSum = data[0], curSum;
		for (int i = 0; i < data.length; i++) {
			curSum = 0;
			for (int j = i; j < data.length; j++) {
				curSum += data[j];
				maxSum = (curSum > maxSum) ? curSum : maxSum;
			}
		}
		System.out.println(maxSum);
	}

	/*
	 * sum[i]��ʾ��i��β�������еĺ� �Ե�i��Ԫ��������ѡ��: Ҫô����ǰ���������, Ҫô��Ϊ�������еĿ�ͷ 
	 * ״̬ת�Ʒ��̣�sum[i] = math.max(sum[i-1]+data[i], data[i])
	 */
	public static void Dp() {
		int max = Integer.MIN_VALUE, curSum = 0, start = 0, end = 0;
		for (int i = 0; i < data.length; i++) {
			if (curSum >= 0) {
				curSum += data[i];
			} else {
				curSum = data[i];
				start = i;  // update start's index
			}
			if (curSum > max) {
				max = curSum;
				end = i;  // update end's index
			}
		}
		System.out.println(max);
		System.out.println("start with index: " + (start + 1) + "\t" + "end with index: " + (end + 1));
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		data = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = input.nextInt();
		}
		Violence();
		Dp();
		input.close();
	}

}
