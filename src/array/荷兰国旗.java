package array;

import java.util.Arrays;

/*
 * �к����������ɫ����n��������У������ǵ�������ǽ���n���򰴺졢�ס���˳���źá�
 * */
public class �������� {

	static int[] flags = { 1, 2, 0, 1, 0, 0, 2, 1, 1, 2 };
	static int len;

	static {
		len = flags.length;
	}

	public static void violent() {
		int zero = 0, one = 0, two = 0;
		for (int i = 0; i < len; i++) {
			if (flags[i] == 0) {
				++zero;
			} else if (flags[i] == 1) {
				++one;
			} else {
				++two;
			}
		}
		int pos = 0, sum;
		while (true) {
			sum = zero + one + two;
			if (sum <= 0) {
				break;
			}
			if (zero > 0) {
				flags[pos++] = 0;
				--zero;
			} else if (one > 0) {
				flags[pos++] = 1;
				--one;
			} else if (two > 0) {
				flags[pos++] = 2;
				--two;
			}
		}
		System.out.println(Arrays.toString(flags));
	}
	
	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j]; 
		arr[j] = t; 
	}
	
	/*
	 * ���ÿ��������˼��, ������ָ��ֻ����һ����������(ʱ�临�Ӷ�O(1))
	 * ָ��begin: ָ��ͷ
	 * ָ��current: ��������,��ɽ���
	 * ָ��end: ָ��ĩβ
	 * ��currentΪ0, ��begin��������++begin, ++current
	 * ��currentΪ1, ������, ++current
	 * ��currentΪ2, ��end��������--current, --end (--current����Ϊ����֮ǰend��0�Ļ�,����֮��currentλ�þͱ��0,currentҪ��ȥ����)
	 * */
	public static void mySort() {
		int begin = 0, current = 0, end = len - 1;
		while(current <= end) {
			if (flags[current] == 0) {
				swap(flags, begin, current);
				++begin;
				++current;
			}else if (flags[current] == 1) {
				++current;
			}else if (flags[current] == 2) {
				swap(flags, current, end);
				--current;
				--end;
			}
		}
		System.out.println(Arrays.toString(flags));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		violent();
		mySort();
	}

}
