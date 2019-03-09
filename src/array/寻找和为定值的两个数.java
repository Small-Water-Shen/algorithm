package array;

import java.util.Arrays;

public class Ѱ�Һ�Ϊ��ֵ�������� {

	static int[] arr = { 1, 5, 6, 2, 8, 10 };
	static final int number = 15;

	// ����ɢ�б�(hash)ӳ��, �ռ任ʱ��ķ���. ����hash��Ҫ�ռ�O(n),ʱ�����O(1)
	public static void func1() {
		int[] inflect = new int[number];
		for (int i = 0; i < arr.length; i++) {
			inflect[arr[i]] = 1;
		}
		for (int i = 0; i < inflect.length; i++) {
			if (inflect[i] != 0 && inflect[number - i] != 0) {
				System.out.println(i + " + " + (number - i) + " = " + number);
				return;
			}
		}
	}

	// ������, ����λָ��б�ɨ
	public static void func2() {
		Arrays.sort(arr);
		int low = 0, hight = arr.length - 1;
		while (low < hight) {
			int sum = arr[low] + arr[hight];
			if (sum == number) {
				System.out.println(arr[low] + " + " + arr[hight] + " = " + number);
				return;
			} else if (sum < number) {
				++low;
			} else {
				--hight;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		func2();
	}

}
