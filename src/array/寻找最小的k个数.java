package array;

import java.util.Arrays;

public class Ѱ����С��k���� {

	static int[] arr = { 5, 1, 4, 2, 3, 9 };
	static final int k = 3;

	public static void quickSort(int[] arr, int left, int right) {
		// �������
		if (left >= right) {
			return;
		}
		// ѡleftλ�õ���Ϊ����
		int radix = arr[left];
		int l = left + 1, r = right, t;
		while (l != r) {
			// ���ұ߿�ʼ�ұ�radixС��һ����
			while (l < r && radix < arr[r]) {
				--r;
			}
			// ����߱߿�ʼ�ұ�radix���һ����
			while (l < r && radix > arr[l]) {
				++l;
			}
			// ����λ��
			if (l < r) {
				t = arr[l];
				arr[l] = arr[r];
				arr[r] = t;
			}
		}
		// ����radix�͵�ǰ�ཻ�㽻��λ��
		arr[left] = arr[l];
		arr[l] = radix;
		// ����������
		quickSort(arr, left, l - 1);
		// ���Ұ������
		quickSort(arr, l + 1, right);
	}

	/*
	 * ȫ������, ����ǰk��
	 */
	public static void func1() {
		// TODO Auto-generated method stub
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/*
	 * ����һ��k���ȵ����� 
	 * ���������k��������,
	 * Ȼ��ѡ���������ֵ��kmax ����ʣ�µ�n-k��Ԫ��, ����Ԫ��i<kmax�����k���ȵ�����
	 * ѡ��������һ���������
	 */
	public static void func2() {
		// TODO Auto-generated method stub
		int[] values = new int[k];
		for (int i = 0; i < k; i++) {
			values[i] = arr[i];
		}
		int Kmax = Integer.MIN_VALUE, record = 0;
		// update Kmax
		for (int i = 0; i < k; i++) {
			if (values[i] > Kmax) {
				Kmax = values[i];
				record = i;
			}
		}
		for (int i = k; i < arr.length; i++) {
			if (arr[i] < Kmax) {
				values[record] = arr[i];
				// update Kmax
				Kmax = Integer.MIN_VALUE;
				for (int j = 0; j < k; j++) {
					if (values[j] > Kmax) {
						Kmax = values[j];
						record = j;
					}
				}
			}
		}
		System.out.println(Arrays.toString(values));
	}

	public static void func3() {
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
		func3();
	}

}
