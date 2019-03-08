package array;

import java.util.Arrays;

/*
 * ����һ����������,����˳��,ʹ����������λ������ǰ�벿��,ż��λ�ں�벿��
 * */
public class ��ż������ {

	static int[] arr = { 2, 8, 7, 1, 3, 5, 6, 4 };

	// һ��ָ��ɨ,����ż���������,��ż�����������ǰ��,�ٽ�ż����ĩβ,ʱ�临�Ӷ�O(n^2)
	public static void onePointer() {
		int len = arr.length, end = arr.length;
		// ���һλ����ɨ,�������ڶ�λ����
		for (int i = 0; i < end - 1; i++) {
			if (!isOddNum(arr[i])) {
				// �ó���
				int evenNum = arr[i];
				// ���������ǰ��
				for (int p = i + 1; p < len; p++) {
					arr[p - 1] = arr[p];
				}
				--end; // �������һ��ż��, ������������һ��
				--i; // ������һ�����Ƶ���ǰ��,Ҫ��ȥ
				arr[len - 1] = evenNum;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static boolean isOddNum(int number) {
		// ����Binary�����һλ������,����λ����2�ı���������
		return (number & 1) == 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// ����������Ϊ��С����,ż�����ɽϴ����,�����뵽"����"����: ��������
	public static void mySort() {
		int i = 0, j = arr.length - 1;
		while (i < j) {
			// ���ұ��ҵ�һ������
			if (!isOddNum(arr[j])) {
				--j;
			}
			// ������ҵ�һ��ż��
			else if (isOddNum(arr[i])) {
				++i;
			}
			// ���ҵ���ʱ��ͽ���
			else {
				swap(arr, i, j);
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		onePointer();
		mySort();
	}

}
