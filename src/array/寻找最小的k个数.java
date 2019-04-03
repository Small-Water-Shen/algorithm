package array;

import java.util.Arrays;

public class Ѱ����С��k���� {

	static int[] arr = { 3, 4, 2, 8, 5, 1 };
	static final int k = 4;

	public static void quickSort(int[] arr, int left, int right) {
		// �������
		if (left >= right) {
			return;
		}
		// ѡleftλ�õ���Ϊ����
		int radix = arr[left];
		int l = left, r = right, t;
		while (l != r) {
			// ���ұ߿�ʼ�ұ�radixС��һ����
			while (l < r && radix <= arr[r])
				--r;
			// ����߱߿�ʼ�ұ�radix���һ����
			while (l < r && radix >= arr[l])
				++l;
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
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	/*
	 * ����һ��k���ȵ����� ���������k��������, Ȼ��ѡ���������ֵ��kmax ����ʣ�µ�n-k��Ԫ��, ����Ԫ��i<kmax�����k���ȵ�����
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

	// �������
	public static int func3(int a[], int l, int r, int k) {
		// between l ~ r
		int p = (int) (Math.random() * (r - l + 1) + l);
		int x = a[p];
		{
			int t = a[p];
			a[p] = a[r];
			a[r] = t;
		}
		int i = l, j = r;
		while (i < j) {
			while (i < j && a[i] < x) i++;
			if (i < j) {
				a[j] = a[i];
				j--;
			}
			while (i < j && a[j] > x) j--;
			if (i < j) {
				a[i] = a[j];
				i++;
			}
		}
		a[i] = x;
		p = i;
		if (i - l + 1 == k) return a[i];
		if (i - l + 1 < k) return func3(a, i + 1, r, k - (i - l + 1)); // ���
		else return func3(a, l, i - 1, k);
	}

	public static void main(String[] args) {
		System.out.println(func3(arr, 0, arr.length - 1, k));
	}

}
